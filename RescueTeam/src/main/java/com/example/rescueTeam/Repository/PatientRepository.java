package com.example.rescueTeam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rescueTeam.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
