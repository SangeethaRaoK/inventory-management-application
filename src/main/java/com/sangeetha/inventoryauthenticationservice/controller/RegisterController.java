package com.sangeetha.inventoryauthenticationservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sangeetha.inventoryauthenticationservice.dto.RegisterRequest;
import com.sangeetha.inventoryauthenticationservice.dto.UpdateRequest;
import com.sangeetha.inventoryauthenticationservice.dto.UserDetailsDto;
import com.sangeetha.inventoryauthenticationservice.entity.UserDetails;
import com.sangeetha.inventoryauthenticationservice.service.AuthService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/register")
@AllArgsConstructor
@CrossOrigin(origins="*")
public class RegisterController {
	
	private final AuthService authService;
	
	@PostMapping
	public ResponseEntity<UserDetailsDto> register(@RequestBody RegisterRequest registerRequest)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(registerRequest));
	}
	
	@PutMapping
	public ResponseEntity<Map<String,String>> updateUser(@RequestBody UpdateRequest updateRequest){
		return ResponseEntity.status(HttpStatus.CREATED).body(authService.updateUser(updateRequest));
		
	}
	
	
	@GetMapping
	public ResponseEntity<List<UserDetailsDto>> fetchAllUsers(){
		return ResponseEntity.status(HttpStatus.OK).body(authService.fetchAllUsers());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDetailsDto> fetchUserById(@PathVariable Long id){
		
		return ResponseEntity.status(HttpStatus.OK).body(authService.fetchUserById(id));
		
	}
	
	

}
