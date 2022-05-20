package com.javacode.userservice.playeraution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacode.userservice.playeraution.model.User;
import com.javacode.userservice.playeraution.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins = "http://localhost:4200")

	public User registerUser(@RequestBody User user) {
		User userObj = null;
		userObj = userService.saveUser(user);
		return userObj;
	}

	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempUserName = user.getUserName();
		String tempPassword = user.getPassword();
		User userObj = null;
		if(tempUserName != null && tempPassword!=null) {
			userObj = userService.fetchUserByUserNameAndPassword(tempUserName, tempPassword);
		}
		if(userObj == null) {
			throw new Exception("Bad Credentials!");
		}
		return userObj;
	}
}
