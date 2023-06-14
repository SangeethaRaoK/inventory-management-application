package com.sangeetha.inventoryauthenticationservice.service;

import java.util.List;
import java.util.Map;

import com.sangeetha.inventoryauthenticationservice.dto.RegisterRequest;
import com.sangeetha.inventoryauthenticationservice.dto.UpdateRequest;
import com.sangeetha.inventoryauthenticationservice.dto.UserDetailsDto;

public interface AuthService {
	
	UserDetailsDto register(RegisterRequest registerRequest);
	Map<String,String >updateUser(UpdateRequest updateRequest);
	List<UserDetailsDto> fetchAllUsers();
	UserDetailsDto fetchUserById(Long id);

}
