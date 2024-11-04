package com.reglog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reglog.entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long>{
	
	UserEntity findByfullName(String fullName);

}