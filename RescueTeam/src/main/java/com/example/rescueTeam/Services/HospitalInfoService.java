package com.example.rescueTeam.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rescueTeam.Repository.HospitalRepository;
import com.example.rescueTeam.model.Hospital;
@Service
public class HospitalInfoService {
	
	
	 @Autowired
	    private HospitalRepository hospitalRepository;

	    public Hospital saveHospital(Hospital hospital) {
	        return hospitalRepository.save(hospital);
	    }

	    public List<Hospital> getAllHospitals() {
	        return hospitalRepository.findAll();
	    }

	    public Hospital getHospitalById(Long id) {
	        return hospitalRepository.findById(id).orElse(null);
	    }

	    public Hospital updateHospital(Long id, Hospital hospitalDetails) {
	        Hospital hospital = getHospitalById(id);
	        if (hospital != null) {
	            hospital.setHospName(hospitalDetails.getHospName());
	            hospital.setAvailability(hospitalDetails.isAvailability());
	            hospital.setNumberOfBeds(hospitalDetails.getNumberOfBeds());
	            return hospitalRepository.save(hospital);
	        }
	        return null;
	    }

}
