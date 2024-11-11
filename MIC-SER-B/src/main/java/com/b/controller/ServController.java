package com.b.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b.model.newModel;
import com.b.service.ServB;

@RestController
@RequestMapping("/b")
public class ServController {

	@Autowired
	private ServB service;
	
	@GetMapping("/info")
	public List<newModel> get(){
		return service.getAll();
	}
}
