package com.example.rescueTeam.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.messageSystem.model.SosMessage;
import com.example.rescueTeam.Services.PatientService;
import com.example.rescueTeam.model.Patient;
import com.example.rescueTeam.model.RescueRequest;

@RestController
@RequestMapping("/hospital")
@CrossOrigin
public class PatientController {
	
	@Autowired
	private PatientService patientService;

	@PostMapping("/admit")
	public String admitPatient(@RequestBody Patient patient) {


		if (patientService.isHospitalAvailable()) {
			patientService.savePatient(patient);
			return "Patient " + patient.getPatientName();
		} else {
			return "No hospitals available at this moment.";
		}
		
	}

	@GetMapping("/availability")
	public boolean checkHospitalAvailability() {
		return patientService.isHospitalAvailable();
	}

	
	@GetMapping("/patients")
	public List<Patient> getPatients() {
		return patientService.getAllPatients();
	}
	
	
}




/*

@Autowired
private PatientService patientService;
@PostMapping("/admit")
public String admitPatient(
        @RequestBody Patient patient,
        @RequestParam(required = false) String location,
        @RequestParam String severity) {

    // Fetch SOS message from MessageSystem
    SosMessage sosMessage = patientService.fetchSosMessage(location, severity);

    // Print or log the SOS message details (for debugging or auditing)
    System.out.println("Received SOS message: " + sosMessage);

    // Check hospital availability and admit the patient
    if (patientService.isHospitalAvailable()) {
        patientService.savePatient(patient);
        return "Patient " + patient.getName() + " admitted successfully. Severity: " + sosMessage.getSeverity();
    } else {
        return "No hospitals available at this moment.";
    }
}
@GetMapping("/availability")
public boolean checkHospitalAvailability() {
    return patientService.isHospitalAvailable();
}

@GetMapping("/patients")
public List<Patient> getPatients() {
    return patientService.getAllPatients();
}
*/