package com.sangeetha.inventoryauthenticationservice.service;

import java.util.List;
import java.util.Map;

import com.sangeetha.inventoryauthenticationservice.dto.LoginRequest;
import com.sangeetha.inventoryauthenticationservice.dto.LoginResponse;
import com.sangeetha.inventoryauthenticationservice.dto.RegisterRequest;
import com.sangeetha.inventoryauthenticationservice.dto.UpdateRequest;
import com.sangeetha.inventoryauthenticationservice.dto.UserDetailsDto;
import com.sangeetha.inventoryauthenticationservice.exception.UserNotFoundException;

import jakarta.validation.Valid;

public interface AuthService {
	
	UserDetailsDto register(RegisterRequest registerRequest);
	Map<String,String >updateUser(UpdateRequest updateRequest) throws UserNotFoundException;
	List<UserDetailsDto> fetchAllUsers();
	UserDetailsDto fetchUserById(Long id);
	LoginResponse login(@Valid LoginRequest loginRequest);
	Map<String,String> fetchSecurityQuestionForUser(String username);

}
