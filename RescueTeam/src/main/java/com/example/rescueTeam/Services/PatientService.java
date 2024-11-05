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

	private final boolean hospitalAvailable = true;

	public boolean isHospitalAvailable() {
		return hospitalAvailable;
	}

	public void savePatient(Patient patient) {
		patientRepository.save(patient);
		System.out.println("Patient saved: " + patient.getPatientName());
	}

	public List<Patient> getAllPatients() {
		return patientRepository.findAll();}
	
}

