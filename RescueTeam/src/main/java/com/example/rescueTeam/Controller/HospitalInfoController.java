package com.example.rescueTeam.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rescueTeam.Services.HospitalInfoService;
import com.example.rescueTeam.model.Hospital;


@RestController
@RequestMapping("/hospitalsInfo")
@CrossOrigin
public class HospitalInfoController {
	
	 @Autowired
	    private HospitalInfoService hospitalService;

	    // Endpoint to add a new hospital
	    @PostMapping("/add")
	    public Hospital addHospital(@RequestBody Hospital hospital) {
	        return hospitalService.saveHospital(hospital);
	    }

	    // Endpoint to get all hospitals
	    @GetMapping("/all")
	    public List<Hospital> getAllHospitals() {
	        return hospitalService.getAllHospitals();
	    }

	    // Endpoint to get a specific hospital by ID
	    @GetMapping("/{id}")
	    public Hospital getHospitalById(@PathVariable Long id) {
	        return hospitalService.getHospitalById(id);
	    }

	    // Endpoint to update hospital details
	    @PutMapping("/update/{id}")
	    public Hospital updateHospital(@PathVariable Long id, @RequestBody Hospital hospitalDetails) {
	        return hospitalService.updateHospital(id, hospitalDetails);
	    }

}
