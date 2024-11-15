package com.example.hospitalManagement.controller;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospitalManagement.model.PatientDetails;
import com.example.hospitalManagement.model.PatientStatus;
import com.example.hospitalManagement.service.PatientStatusService;

@RestController
@RequestMapping("/patient-status")
@CrossOrigin
public class PatientStatusController {
	
	@Autowired
    private PatientStatusService patientStatusService;

    
    @PostMapping("/add")
    public PatientStatus addPatientStatus(@RequestBody PatientStatus patientStatus) {
    	patientStatus.setStatusUpdatedTime(LocalDateTime.now()); 
        return patientStatusService.saveDetails(patientStatus);
    }
    
    @PutMapping("/update/{id}")
    public PatientStatus updatePatientStatus(@PathVariable long id, @RequestBody PatientDetails patientDetails) {

    	Optional<PatientStatus> existingPatientDetails = patientStatusService.getDetailsById(id);
        
    	if (existingPatientDetails != null) {
        	
        	PatientStatus patient = existingPatientDetails.get();
        	patient.setStatus(patientDetails.getStatus());
        	patient.setNotes(patientDetails.getNotes());
        	patient.setStatusUpdatedTime(LocalDateTime.now());
        	
        	return patientStatusService.saveDetails(patient);
        } else {
            throw new RuntimeException("Patient details not found");
        }
    }

    @GetMapping("/getNotAdmitted")
    public List<PatientStatus> getAllNotAdmitted(){
    	return patientStatusService.getNotAdmittedPatients();
    }
 
    @GetMapping("/getAllForPatient/{patientId}")
    public List<PatientStatus> getStatusesForPatient(@PathVariable Long patientId) {
        return patientStatusService.getStatusesForPatient(patientId);
    }
    
    @GetMapping("/getAll")
    public List<PatientStatus> getAllPatientStatuses() {
        return patientStatusService.getAllPatientStatuses();
    }

}
