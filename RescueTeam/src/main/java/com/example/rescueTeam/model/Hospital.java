package com.example.rescueTeam.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name ="hospitalInfo")
public class Hospital {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospId;

    private String hospName;
    private boolean availability;
    private int numberOfBeds;

    // Getters and Setters
    public Long getHospId() { return hospId; }
    public void setHospId(Long id) { this.hospId = id; }

    public String getHospName() { return hospName; }
    public void setHospName(String name) { this.hospName = name; }

    public boolean isAvailability() { return availability; }
    public void setAvailability(boolean availability) { this.availability = availability; }

    public int getNumberOfBeds() { return numberOfBeds; }
    public void setNumberOfBeds(int numberOfBeds) { this.numberOfBeds = numberOfBeds; }
}
