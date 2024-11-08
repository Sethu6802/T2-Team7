package com.example.rescueTeam.Services;

//import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rescueTeam.Repository.PatientRepository;
import com.example.rescueTeam.model.Patient;


@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	private final boolean hospitalAvailable = true; // For simplicity; make dynamic if needed.

	public boolean isHospitalAvailable() {
		return hospitalAvailable;
	}

	public void savePatient(Patient patient) {
		// Save patient to database using repository
		patientRepository.save(patient);
		System.out.println("Patient saved: " + patient.getPatientName());
	}

	public List<Patient> getAllPatients() {
		// Retrieve all patients from the database
		return patientRepository.findAll();}
	
}

