package com.sangeetha.inventoryauthenticationservice.mapper;



import com.sangeetha.inventoryauthenticationservice.dto.RegisterRequest;
import com.sangeetha.inventoryauthenticationservice.dto.UpdateRequest;
import com.sangeetha.inventoryauthenticationservice.dto.UserDetailsDto;
import com.sangeetha.inventoryauthenticationservice.entity.User;
import com.sangeetha.inventoryauthenticationservice.entity.UserDetails;
import com.sangeetha.inventoryauthenticationservice.enums.GENDER;

public class UserDetailsMapper {
	
	public static UserDetails registerToUserDetails(RegisterRequest registerRequest) {
		
		User user=User.builder()
				.username(registerRequest.getUserName())
				.password(registerRequest.getPassword())
				.role("User")
				.build();
		
		UserDetails userDetails=UserDetails.builder()
				.user(user)
			      .address(registerRequest.getAddress())
			      .firstName(registerRequest.getFirstName())
			      .lastName(registerRequest.getLastName())
			      .securityQuestion("Default Question")
			      .securityAnswer("answer")
			      .designation(registerRequest.getDesignation())
			      .gender(GENDER.valueOf(registerRequest.getGender()))
			      .dob(registerRequest.getDob())
			      .emailId(registerRequest.getEmailId())
			      .phoneNumber(registerRequest.getPhoneNo())
			      .build();
					
		return userDetails;
	}
	
	public static UserDetails updateRequestToUserDetails(UpdateRequest updateRequest) {
		return UserDetails.builder()
			      .firstName(updateRequest.getFirstName())
			      .lastName(updateRequest.getLastName())
			      .address(updateRequest.getAddress())
			      .userDetailsId(updateRequest.getUserId())
			      .phoneNumber(updateRequest.getPhoneNo())
			      .gender(GENDER.valueOf(updateRequest.getGender()))
			      .designation(updateRequest.getDesignation())
			      .dob(updateRequest.getDob())
			      .emailId(updateRequest.getEmailId())
			      .securityQuestion(updateRequest.getSecurityQuestion())
			      .securityAnswer(updateRequest.getSecurityAnswer())
			      .build();
	}
	
	public static UserDetailsDto userDetailsToDto(UserDetails userDetails) {
		return UserDetailsDto.builder()
			      .userId(userDetails.getUserDetailsId())
			      .userName(userDetails.getUser().getUsername())
			      .role(userDetails.getUser().getRole())
			      .phoneNo(userDetails.getPhoneNumber())
			      .gender(userDetails.getGender().toString())
			      .designation(userDetails.getDesignation())
			      .dob(userDetails.getDob())
			      .emailId(userDetails.getEmailId())
			      .address(userDetails.getAddress())
			      .firstName(userDetails.getFirstName())
			      .lastName(userDetails.getLastName())
			      .build();
	}

}
