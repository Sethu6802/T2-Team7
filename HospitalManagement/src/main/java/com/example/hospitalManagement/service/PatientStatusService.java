package com.example.hospitalManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospitalManagement.model.PatientStatus;
import com.example.hospitalManagement.repository.PatientStatusRepository;

@Service
public class PatientStatusService {
	
	@Autowired
    private PatientStatusRepository patientStatusRepository;

    // Save a new patient status
    public PatientStatus savePatientStatus(PatientStatus patientStatus) {
        return patientStatusRepository.save(patientStatus);
    }

    // Retrieve all statuses for a patient
    public List<PatientStatus> getStatusesForPatient(Long patientId) {
        return patientStatusRepository.findAll()
                                      .stream()
                                      .filter(status -> status.getPatient().getId().equals(patientId))
                                      .toList();
    }

}
