package com.example.hospitalManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospitalManagement.model.PatientStatus;
import com.example.hospitalManagement.service.PatientStatusService;

@RestController
@RequestMapping("/patient-status")
public class PatientStatusController {
	
	@Autowired
    private PatientStatusService patientStatusService;

    // Endpoint to add a status for a patient
    @PostMapping("/add")
    public PatientStatus addPatientStatus(@RequestBody PatientStatus patientStatus) {
        return patientStatusService.savePatientStatus(patientStatus);
    }

    // Endpoint to get all statuses for a specific patient
    @GetMapping("/getAllForPatient/{patientId}")
    public List<PatientStatus> getStatusesForPatient(@PathVariable Long patientId) {
        return patientStatusService.getStatusesForPatient(patientId);
    }

}
