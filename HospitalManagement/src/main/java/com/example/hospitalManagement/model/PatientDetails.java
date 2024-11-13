package com.example.hospitalManagement.model;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private LocalDateTime statusUpdatedTime;
    private String status;
    private String notes;

}