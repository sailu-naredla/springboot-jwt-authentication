package com.jwt.dto;

import lombok.Data;

@Data
public class AuthRequest {

	private String name;
	
	private String password;
}
