package com.b.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.b.model.newModel;

@Repository
public interface RepoB extends JpaRepository<newModel, Integer>{

	
	
}
