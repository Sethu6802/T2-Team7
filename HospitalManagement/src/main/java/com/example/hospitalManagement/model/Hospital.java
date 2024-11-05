package com.example.hospitalManagement.model;

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
@Table(name="hospital")
public class Hospital {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospId;

    private String hospName;
    private int age;
    private String insuranceNumber;
    private String bystander;
    private String phoneNumber;
    private String address;
    private String medicalCondition;

}
