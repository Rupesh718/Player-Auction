package com.javacode.userservice.playeraution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacode.userservice.playeraution.model.User;
import com.javacode.userservice.playeraution.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public User fetchUserByUserNameAndPassword(String userName, String password) {
		return userRepository.findByUserNameAndPassword(userName, password);
	}
} 
