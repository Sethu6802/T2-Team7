package com.reglog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reglog.entity.UserEntity;
import com.reglog.service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public UserEntity register(@RequestBody UserEntity user) {
		return userService.registerUser(user);
	}
	
	@PostMapping("/login")
	public UserEntity login(@RequestBody UserEntity user) {
		return userService.findByName(user.getFullName());
	}
	
	@GetMapping("/allUsers")
	public List<UserEntity> info(){
		return userService.getAll();
	}
	
}