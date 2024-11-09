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

	    // Endpoint to register a volunteer as a Service Provider
	    @PostMapping("/register/service-provider")
	    public ServiceProvider registerServiceProvider(@RequestBody ServiceProvider serviceProvider) {
	        return volunteerService.saveServiceProvider(serviceProvider);
	    }

	    // Endpoint to register a volunteer as a Helper
	    @PostMapping("/register/helper")
	    public Helper registerHelper(@RequestBody Helper helper) {
	        return volunteerService.saveHelper(helper);
	    }

	    // Endpoint to report an incident (just a placeholder, as reporting details would depend on requirements)
	    @PostMapping("/report-incident")
	    public String reportIncident(@RequestBody String incidentDetails) {
	        // Handle incident reporting, log details, notify rescue team, etc.
	        return "Incident reported successfully: " + incidentDetails;
	    }
	    
	

	    // Get all Service Providers
	    @GetMapping("/service-providers")
	    public List<ServiceProvider> getAllServiceProviders() {
	        return volunteerService.getAllServiceProviders();
	    }

	    // Get a Service Provider by ID
	    @GetMapping("/service-provider/{id}")
	    public ServiceProvider getServiceProviderById(@PathVariable Long id) {
	        return volunteerService.getServiceProviderById(id);
	    }

	    // Get all Helpers
	    @GetMapping("/helpers")
	    public List<Helper> getAllHelpers() {
	        return volunteerService.getAllHelpers();
	    }

	    // Get a Helper by ID
	    @GetMapping("/helper/{id}")
	    public Helper getHelperById(@PathVariable Long id) {
	        return volunteerService.getHelperById(id);
	    }
     
	

	    // Update a Service Provider by ID
	    @PutMapping("/service-provider/{id}")
	    public ServiceProvider updateServiceProvider(@PathVariable Long id, @RequestBody ServiceProvider serviceProvider) {
	        return volunteerService.updateServiceProvider(id, serviceProvider);
	    }

	    // Update a Helper by ID
	    @PutMapping("/helper/{id}")
	    public Helper updateHelper(@PathVariable Long id, @RequestBody Helper helper) {
	        return volunteerService.updateHelper(id, helper);
	    }
	    
	

	    // Delete a Service Provider by ID
	    @DeleteMapping("/service-provider/{id}")
	    public String deleteServiceProvider(@PathVariable Long id) {
	        volunteerService.deleteServiceProvider(id);
	        return "Service Provider with ID " + id + " deleted successfully.";
	    }

	    // Delete a Helper by ID
	    @DeleteMapping("/helper/{id}")
	    public String deleteHelper(@PathVariable Long id) {
	        volunteerService.deleteHelper(id);
	        return "Helper with ID " + id + " deleted successfully.";
	    }
}
