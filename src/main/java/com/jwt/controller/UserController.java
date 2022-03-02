package com.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.dto.AuthRequest;
import com.jwt.dto.User;
import com.jwt.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
    public User saveUser(@RequestBody User user) {
		log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }
	
	@PostMapping("/authenticate")
    public User authUser(@RequestBody AuthRequest authRequest) {
		log.info("Inside authUser of UserController");
        return userService.authenticateUser(authRequest);
    }
	
	@GetMapping("/protected")
    public String tokenBasesAccess() {
		log.info("Inside tokenBasesAccess of UserController");
		return "Access granted for given token";
    }
	
}
