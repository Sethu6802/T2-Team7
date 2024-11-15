package com.example.hospitalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospitalManagement.model.PatientDetails;
import com.example.hospitalManagement.model.PatientStatus;

public interface PatientDetailsRepo extends JpaRepository<PatientDetails, Long>{

	PatientStatus save(PatientStatus patientStatus);

}
