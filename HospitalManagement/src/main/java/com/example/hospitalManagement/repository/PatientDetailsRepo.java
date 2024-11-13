package com.example.hospitalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospitalManagement.model.PatientDetails;

public interface PatientDetailsRepo extends JpaRepository<PatientDetails, Long>{

}
