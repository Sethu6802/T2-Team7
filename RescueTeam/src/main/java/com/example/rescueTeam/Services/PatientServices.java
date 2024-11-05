package com.example.rescueTeam.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.example.messageSystem.model.SosMessage;
import com.example.rescueTeam.Repository.PatientRepository;
import com.example.rescueTeam.model.Patient;

public class PatientServices {

	@Autowired
    private RestTemplate restTemplate;
	@Autowired
	private PatientRepository patientRepository;

    public SosMessage fetchSosMessage(String location, String severity) {
        String url = "http://message-system/message/sendSosMessage?location=" + location + "&severity=" + severity;
        return restTemplate.getForObject(url, SosMessage.class);
    }

    public Patient savePatient(Patient patient) {
        // Save patient to the database (implementation depends on your setup)
        return patientRepository.save(patient);
    }
}
