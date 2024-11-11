package com.feign.service;

import javax.tools.JavaFileManager.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeignService {

	@Autowired
	private Location location;
	
}