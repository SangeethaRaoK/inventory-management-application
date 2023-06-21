package com.sangeetha.inventoryauthenticationservice.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sangeetha.inventoryauthenticationservice.dto.LoginRequest;
import com.sangeetha.inventoryauthenticationservice.dto.LoginResponse;
import com.sangeetha.inventoryauthenticationservice.service.AuthService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@CrossOrigin(origins="*")
public class AuthController {
	private final AuthService authService;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest){
		return ResponseEntity.status(HttpStatus.OK).body(authService.login(loginRequest));
	}
	
	@GetMapping("/forgotpassword/{username}")
	  public ResponseEntity<Map<String, String>> forgotPassword(@PathVariable String username) {
	    return ResponseEntity.status(HttpStatus.OK).body(authService.fetchSecurityQuestionForUser(username));
	  }

}
