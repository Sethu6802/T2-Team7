package com.example.messageSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class SosMessage {
	@Id
	@GeneratedValue
	private long id;// new addition

    private String location;
    private String ipAddress;
    private String time;
    private String message;

    // Constructors
    public  SosMessage() {
    }

    public SosMessage(String location, String ipAddress, String time, String message) {
        this.location = location;
        this.ipAddress = ipAddress;
        this.time = time;
        this.message = message;
    }

    // Getters and setters
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	
}
