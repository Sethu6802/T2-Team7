package com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a.model.Model;
import com.a.repo.RepoA;

@Service
public class ServA {

	@Autowired
	private RepoA repo;
	
	public List<Model> getAll() {
		return repo.findAll();
	}
}
