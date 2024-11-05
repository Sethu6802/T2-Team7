package com.example.hospitalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospitalManagement.model.Hospital;
@Repository
public interface PatientInfoRepository extends JpaRepository<Hospital, Long>{

}
