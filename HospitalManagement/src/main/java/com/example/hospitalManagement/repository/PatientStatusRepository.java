package com.example.hospitalManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospitalManagement.model.PatientStatus;
@Repository
public interface PatientStatusRepository  extends JpaRepository<PatientStatus, Long>  {
	
	public List<PatientStatus> findByStatus(String status);

}
