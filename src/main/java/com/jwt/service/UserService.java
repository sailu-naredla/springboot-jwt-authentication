package com.jwt.service;

import com.jwt.dto.AuthRequest;
import com.jwt.dto.User;

public interface UserService {
	
	public User saveUser(User user);
	
	public User authenticateUser(AuthRequest authRequest);
	
}
