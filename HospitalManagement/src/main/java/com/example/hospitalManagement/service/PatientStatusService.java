package com.example.hospitalManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospitalManagement.model.PatientDetails;
import com.example.hospitalManagement.model.PatientStatus;
import com.example.hospitalManagement.repository.PatientDetailsRepo;
import com.example.hospitalManagement.repository.PatientStatusRepository;

@Service
public class PatientStatusService {
	
	@Autowired
    private PatientStatusRepository patientStatusRepository;
	
	@Autowired
	private PatientDetailsRepo patientDetailsRepo;
	
	
	
	public List<PatientStatus> getNotAdmittedPatients(){
		return patientStatusRepository.findByStatus("not-admitted");
	}

	
    public PatientStatus savePatientStatus(PatientStatus patientStatus) {
        return patientStatusRepository.save(patientStatus);
    }

    
    public List<PatientStatus> getStatusesForPatient(Long patientId) {
        return patientStatusRepository.findAll()
                                      .stream()
                                      .filter(status -> status.getPatient().getId().equals(patientId))
                                      .toList();
    }
    
    
    public List<PatientStatus> getAllPatientStatuses() {
        return patientStatusRepository.findAll();
    }

    
    public PatientStatus saveDetails(PatientStatus patientStatus) {
    	return patientDetailsRepo.save(patientStatus);
    }


	public Optional<PatientStatus> getDetailsById(long id) {
		return patientStatusRepository.findById(id);
	}
}
