package com.example.volunteer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.volunteer.model.Helper;
import com.example.volunteer.model.ServiceProvider;
import com.example.volunteer.repository.HelperRepository;
import com.example.volunteer.repository.ServiceProviderRepository;

import java.util.List;
//import java.util.Optional;

@Service
public class VolunteerService {

    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    @Autowired
    private HelperRepository helperRepository;

    // Save a Service Provider
    public ServiceProvider saveServiceProvider(ServiceProvider serviceProvider) {
        return serviceProviderRepository.save(serviceProvider);
    }

    // Save a Helper
    public Helper saveHelper(Helper helper) {
        return helperRepository.save(helper);
    }

    // Get all Service Providers
    public List<ServiceProvider> getAllServiceProviders() {
        return serviceProviderRepository.findAll();
    }

    // Get a Service Provider by ID
    public ServiceProvider getServiceProviderById(Long id) {
        return serviceProviderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service Provider not found with ID: " + id));
    }

    // Get all Helpers
    public List<Helper> getAllHelpers() {
        return helperRepository.findAll();
    }

    // Get a Helper by ID
    public Helper getHelperById(Long id) {
        return helperRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Helper not found with ID: " + id));
    }

    // Update a Service Provider by ID
    public ServiceProvider updateServiceProvider(Long id, ServiceProvider serviceProviderDetails) {
        ServiceProvider existingServiceProvider = getServiceProviderById(id);
        existingServiceProvider.setName(serviceProviderDetails.getName());
        existingServiceProvider.setServiceType(serviceProviderDetails.getServiceType());
        existingServiceProvider.setAvailable(serviceProviderDetails.isAvailable());
        return serviceProviderRepository.save(existingServiceProvider);
    }

    // Update a Helper by ID
    public Helper updateHelper(Long id, Helper helperDetails) {
        Helper existingHelper = getHelperById(id);
        existingHelper.setName(helperDetails.getName());
        existingHelper.setAvailabilityStatus(helperDetails.getAvailabilityStatus());
        return helperRepository.save(existingHelper);
    }

    // Delete a Service Provider by ID
    public void deleteServiceProvider(Long id) {
        ServiceProvider serviceProvider = getServiceProviderById(id);
        serviceProviderRepository.delete(serviceProvider);
    }

    // Delete a Helper by ID
    public void deleteHelper(Long id) {
        Helper helper = getHelperById(id);
        helperRepository.delete(helper);
    }
}

