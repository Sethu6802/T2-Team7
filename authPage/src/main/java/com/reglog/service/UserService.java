package com.reglog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reglog.entity.UserEntity;
import com.reglog.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public UserEntity registerUser(UserEntity user) {
		return userRepo.save(user);
	}

	public UserEntity findByName(String name) {
		return userRepo.findByfullName(name);
	}
	
	public List<UserEntity> getAll(){
		return userRepo.findAll();
	}
}