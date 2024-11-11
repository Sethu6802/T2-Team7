package com.b.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b.model.newModel;
import com.b.repo.RepoB;

@Service
public class ServB {

	@Autowired
	private RepoB repo;
	
	public List<newModel> getAll() {
		return repo.findAll();
	}
}
