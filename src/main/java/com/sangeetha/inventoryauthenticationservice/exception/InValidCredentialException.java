package com.sangeetha.inventoryauthenticationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InValidCredentialException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String fieldname;
	private String message;

}
