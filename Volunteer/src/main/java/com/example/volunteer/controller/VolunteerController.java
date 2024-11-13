package com.example.volunteer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.volunteer.model.Helper;
import com.example.volunteer.model.ServiceProvider;
import com.example.volunteer.service.VolunteerService;

@RestController
@RequestMapping("/volunteer")
public class VolunteerController {
	 @Autowired
	    private VolunteerService volunteerService;

	  
	    @PostMapping("/register/service-provider")
	    public ServiceProvider registerServiceProvider(@RequestBody ServiceProvider serviceProvider) {
	        return volunteerService.saveServiceProvider(serviceProvider);
	    }

	    
	    @PostMapping("/register/helper")
	    public Helper registerHelper(@RequestBody Helper helper) {
	        return volunteerService.saveHelper(helper);
	    }


	    @PostMapping("/report-incident")
	    public String reportIncident(@RequestBody String incidentDetails) {
	        // Handle incident reporting, log details, notify rescue team, etc.
	        return "Incident reported successfully: " + incidentDetails;
	    }
	    
	


	    @GetMapping("/service-providers")
	    public List<ServiceProvider> getAllServiceProviders() {
	        return volunteerService.getAllServiceProviders();
	    }

	    
	    @GetMapping("/service-provider/{id}")
	    public ServiceProvider getServiceProviderById(@PathVariable Long id) {
	        return volunteerService.getServiceProviderById(id);
	    }

	   
	    @GetMapping("/helpers")
	    public List<Helper> getAllHelpers() {
	        return volunteerService.getAllHelpers();
	    }

	   
	    @GetMapping("/helper/{id}")
	    public Helper getHelperById(@PathVariable Long id) {
	        return volunteerService.getHelperById(id);
	    }
     
	

	    
	    @PutMapping("/service-provider/{id}")
	    public ServiceProvider updateServiceProvider(@PathVariable Long id, @RequestBody ServiceProvider serviceProvider) {
	        return volunteerService.updateServiceProvider(id, serviceProvider);
	    }

	 
	    @PutMapping("/helper/{id}")
	    public Helper updateHelper(@PathVariable Long id, @RequestBody Helper helper) {
	        return volunteerService.updateHelper(id, helper);
	    }
	    
	

	    
	    @DeleteMapping("/service-provider/{id}")
	    public String deleteServiceProvider(@PathVariable Long id) {
	        volunteerService.deleteServiceProvider(id);
	        return "Service Provider with ID " + id + " deleted successfully.";
	    }

	    
	    @DeleteMapping("/helper/{id}")
	    public String deleteHelper(@PathVariable Long id) {
	        volunteerService.deleteHelper(id);
	        return "Helper with ID " + id + " deleted successfully.";
	    }
}
