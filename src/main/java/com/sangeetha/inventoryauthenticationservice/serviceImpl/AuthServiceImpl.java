package com.sangeetha.inventoryauthenticationservice.serviceImpl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sangeetha.inventoryauthenticationservice.dto.LoginRequest;
import com.sangeetha.inventoryauthenticationservice.dto.LoginResponse;
import com.sangeetha.inventoryauthenticationservice.dto.RegisterRequest;
import com.sangeetha.inventoryauthenticationservice.dto.UpdateRequest;
import com.sangeetha.inventoryauthenticationservice.dto.UserDetailsDto;
import com.sangeetha.inventoryauthenticationservice.entity.User;
import com.sangeetha.inventoryauthenticationservice.entity.UserDetails;
import com.sangeetha.inventoryauthenticationservice.exception.InValidCredentialException;
import com.sangeetha.inventoryauthenticationservice.exception.UserNotFoundException;
import com.sangeetha.inventoryauthenticationservice.mapper.UserDetailsMapper;
import com.sangeetha.inventoryauthenticationservice.repository.AddressRepository;
import com.sangeetha.inventoryauthenticationservice.repository.UserDetailsRepository;
import com.sangeetha.inventoryauthenticationservice.repository.UserRepository;
import com.sangeetha.inventoryauthenticationservice.security.JwtProvider;
import com.sangeetha.inventoryauthenticationservice.service.AuthService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {
	private final UserRepository userRepository;
	private final UserDetailsRepository userDetailsRepository;
	private final PasswordEncoder passwordEncoder;
	@Lazy
	private final JwtProvider jwtProvider;
	private final AddressRepository addressRepository;


	@Override
	public UserDetailsDto register(RegisterRequest registerRequest) {
		// TODO Auto-generated method stub
		if(!checkIfUserNameExists(registerRequest.getUserName()))
		{
			registerRequest.setPassword(encodePassword(registerRequest.getPassword()));
			registerRequest.setAddress(null);
			UserDetails userDetails= userDetailsRepository.save(UserDetailsMapper.registerToUserDetails(registerRequest));
		
		
		return UserDetailsMapper.userDetailsToDto(userDetails);
		}
		else
		{
			return null;
		}
		
	}

	private String encodePassword(String password) {
		// TODO Auto-generated method stub
		return passwordEncoder.encode(password);
	}

	private boolean checkIfUserNameExists(String userName) throws InValidCredentialException {
		// TODO Auto-generated method stub
		if(!userRepository.existsByUsername(userName))
			return false;
		else
			throw new InValidCredentialException("userName","User name already exists");
	}

	@Override
	public Map<String, String> updateUser(UpdateRequest updateRequest) throws UserNotFoundException {
		// TODO Auto-generated method stub
		UserDetails userDetails = userDetailsRepository.findById(updateRequest.getUserId()).orElseThrow(()->new UserNotFoundException());
		
		
		updateRequest.getAddress().setAddressId(userDetails.getAddress().getAddressId());
		addressRepository.save(updateRequest.getAddress());
		userDetailsRepository.save(UserDetailsMapper.updateRequestToUserDetails(updateRequest) );
		return Collections.singletonMap("userId", updateRequest.getUserId().toString());
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserDetailsDto> fetchAllUsers() {
		// TODO Auto-generated method stub
		List<UserDetailsDto> users = userDetailsRepository.findAll()
		.stream()
		.map(UserDetailsMapper::userDetailsToDto)
		.collect(Collectors.toList());
		return users;
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetailsDto fetchUserById(Long id) {
		// TODO Auto-generated method stub
		return UserDetailsMapper.userDetailsToDto(
		userDetailsRepository.findById(id)
		.orElseThrow(()->new InValidCredentialException("userid","user with the id"+id+"  does not exist")));
		
	}

	@Override
	public LoginResponse login(@Valid LoginRequest loginRequest) {
		// TODO Auto-generated method stub
		User user=findUserByCredentials(loginRequest.getUserName(),loginRequest.getPassWord());
		return LoginResponse.builder()
				.userId(user.getUserId())
				.username(user.getUsername())
				.role(user.getRole())
				.token(jwtProvider.generateTokenWithUsername(user.getUsername())).build();
	}
	
	@Transactional(readOnly = true)
	public User findUserByCredentials(String userName, String passWord) {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(userName).orElseThrow(
				()->new InValidCredentialException("username ","username "+userName
						+"does not exist"));
		if(!passwordEncoder.matches(passWord, user.getPassword()))
			throw new InValidCredentialException("password", "password does not macth");
		return user;
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, String> fetchSecurityQuestionForUser(String username) {
		// TODO Auto-generated method stub
		HashMap<String, String> responseMap = new HashMap<>();
	    responseMap.put("username", username);
	    responseMap.put("securityQuestion", userDetailsRepository.findByUserUsername(username)
	      .orElseThrow(() -> new InValidCredentialException("username", "User " + username + " doesn't exist"))
	      .getSecurityQuestion());
	    return responseMap;
	}

}
