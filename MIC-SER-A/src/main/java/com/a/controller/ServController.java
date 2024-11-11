package com.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.a.model.Model;
import com.a.service.ServA;

@RestController
@RequestMapping("/a")
public class ServController {

	@Autowired
	private ServA service;
	
	@GetMapping("/info")
	public List<Model> getalll(){
		return service.getAll();
	}
}
