package com.example.rescueTeam.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
@RequestMapping("/hospital")
@CrossOrigin
public class HospitalController {
	
	 @Autowired
	    private RestTemplate restTemplate;

	    @GetMapping("/checkPatientAvailability")
	    public String checkPatientAvailability() {
	        String patientInfoServiceUrl = "http://localhost:8094/patient-info/checkAvailability";
	        Boolean isAvailable = restTemplate.getForObject(patientInfoServiceUrl, Boolean.class);

	        return isAvailable != null && isAvailable
	                ? "Hospital is available for admission."
	                : "No availability at the moment.";
	    }

}
