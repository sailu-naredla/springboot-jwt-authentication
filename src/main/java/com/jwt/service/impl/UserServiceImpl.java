package com.jwt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.googlecode.jmapper.JMapper;
import com.jwt.dto.AuthRequest;
import com.jwt.dto.User;
import com.jwt.entity.UserEntity;
import com.jwt.repository.UserRepository;
import com.jwt.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public User saveUser(User user) {
		
		log.info("Entering saveUser");
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		UserEntity userEntity = convertUserToEntiy(user);
		UserEntity savedEntity = userRepository.save(userEntity);
		user = convertEntityToUser(savedEntity);
		user.setPassword(null);
		log.info("Exiting saveUser");
		
		return user;
		
	}

	@Override
	public User authenticateUser(AuthRequest authRequest) {
		return null;
	}
	
	
	private UserEntity convertUserToEntiy(User user) {
		
		log.info("Entering convertProductsToEntity");
		JMapper<UserEntity, User> mapper = new JMapper<>(UserEntity.class, User.class);
		log.info("Exiting convertProductsToEntity");
		
		return mapper.getDestination(user);
		
	}
	
	private User convertEntityToUser(UserEntity userEntity) {
		
		log.info("Entering convertEntityToUser");
		JMapper<User, UserEntity> mapper = new JMapper<>(User.class, UserEntity.class);
		log.info("Exiting convertEntityToUser");
		
		return mapper.getDestination(userEntity);
		
	}

}
