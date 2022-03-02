package com.jwt.dto;

import com.googlecode.jmapper.annotations.JMap;

import lombok.Data;

@Data
public class User {

	@JMap
	private Long id;
	
	@JMap
	private String name;
	
	@JMap
	private String email;
	
	@JMap
	private String password;
	
	
}
