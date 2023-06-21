package com.sangeetha.inventoryauthenticationservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
	@NotBlank
	@Size(min = 5,max=20)
	private String userName;
	@NotBlank
	@Size(min =5,max = 20)
	private String passWord;

}
