package com.example.rescueTeam.model;

import com.example.messageSystem.model.SosMessage;

public class RescueRequest {
	
	private SosMessage sosMessage;
    private String severity;
    private Patient patient;

    // Getters and Setters
    public SosMessage getSosMessage() { return sosMessage; }
    public void setSosMessage(SosMessage sosMessage) { this.sosMessage = sosMessage; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

}
