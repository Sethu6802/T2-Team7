package com.example.hospitalManagement.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patient_status")
public class PatientStatus {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Reference to the Hospital (Patient) entity
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Hospital patient;

    private String status; // E.g., "admitted," "discharged," "in operation"
    private LocalDateTime statusUpdatedTime; // Timestamp for status update

    private String notes;

}
