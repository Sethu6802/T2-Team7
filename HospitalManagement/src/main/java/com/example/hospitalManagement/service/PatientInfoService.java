package com.example.hospitalManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospitalManagement.model.Hospital;
import com.example.hospitalManagement.repository.PatientInfoRepository;
@Service
public class PatientInfoService {
	
	@Autowired
    private PatientInfoRepository patientInfoRepository;

    private boolean hospitalAvailable;  // No default value, must be set externally

    public boolean isHospitalAvailable() {
        return hospitalAvailable;
    }

    // Method to update hospital availability
    public void setHospitalAvailability(boolean availability) {
        this.hospitalAvailable = availability;
    }

    public  Hospital savePatientInfo( Hospital patientInfo) {
        return patientInfoRepository.save(patientInfo);
    }

}
