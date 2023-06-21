package com.sangeetha.inventoryauthenticationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LoginResponse {
	private Long userId;
	private String token;
	private String role;
	private String username;

}
