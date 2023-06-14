package com.sangeetha.inventoryauthenticationservice.dto;

import java.time.LocalDate;

import com.sangeetha.inventoryauthenticationservice.entity.Address;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RegisterRequest {
	@NotBlank
	@Size(min = 5,max = 20)
	private String userName;
	@NotBlank
	@Size(min = 5,max = 20)
	private String password;
	@NotBlank
	@Size(min = 5,max = 20)
	private String designation;
	@NotBlank
	@Pattern(regexp = "^(Male|Female)$", message = "Gender must be Male or Female")
	private String gender;
	@NotBlank
	@Email
	private String emailId;
	@NotBlank
	  
	@Size(min = 10, max = 10, message = "Length of phone number must be 10")
	private String phoneNo;
	
	@Past
	private LocalDate dob;
	@Valid
	private Address address;
	@NotBlank
	@Size(min = 5, max = 30)
	private String firstName;
	@NotBlank
	@Size(min = 5, max = 30)
	private String lastName;
	

}
