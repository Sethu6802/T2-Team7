package com.example.rescueTeam.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "patients")
public class Patient {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long patientId;

	    private String patientName;
	    private int age;
	    private String damageSeverity;
	    private String details; // Additional details about the patient

	    // Getters and setters
	    public Long getPatientId() {
	        return patientId;
	    }

	    public void setPatientId(Long id) {
	        this.patientId = id;
	    }

	    public String getPatientName() {
	        return patientName;
	    }

	    public void setPatientName(String name) {
	        this.patientName = name;
	    }

	    public int getAge() {
	        return age;
	    }

	    public void setAge(int age) {
	        this.age = age;
	    }

	    public String getDamageSeverity() {
	        return damageSeverity;
	    }

	    public void setDamageSeverity(String damageSeverity) {
	        this.damageSeverity = damageSeverity;
	    }

	    public String getDetails() {
	        return details;
	    }

	    public void setDetails(String details) {
	        this.details = details;
	    }

}
