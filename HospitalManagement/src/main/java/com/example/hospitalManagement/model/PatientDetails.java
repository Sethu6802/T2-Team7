package com.example.hospitalManagement.model;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patient_status")
public class PatientDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
	
	private long patient_id;
	
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime statusUpdatedTime;
    private String status;
    private String notes;

}