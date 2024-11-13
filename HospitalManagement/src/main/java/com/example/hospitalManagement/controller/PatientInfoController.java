package com.example.hospitalManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospitalManagement.model.Hospital;
import com.example.hospitalManagement.service.PatientInfoService;

@RestController
@RequestMapping("/patient-info")
@CrossOrigin
public class PatientInfoController {

    @Autowired
    private PatientInfoService patientInfoService;

    @PostMapping("/save")
    public Hospital savePatientInfo(@RequestBody Hospital patientInfo) {
        return patientInfoService.savePatientInfo(patientInfo);
    }

    @GetMapping("/checkAvailability")
    public boolean checkAvailability() {
        return patientInfoService.isHospitalAvailable();
    }

    // Endpoint to set hospital availability
    @PostMapping("/setAvailability")
    public String setAvailability(@RequestParam boolean availability) {
        patientInfoService.setHospitalAvailability(availability);
        return "Hospital availability updated to: " + availability;
    }
}