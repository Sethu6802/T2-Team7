package com.example.messageSystem.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.messageSystem.model.SosMessage;
import com.example.messageSystem.repository.SosMessageRepository;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
public class LocationService {

	 @Autowired
	    private RestTemplate restTemplate;

	    @Autowired
	    private SosMessageRepository sosMessageRepository;

	    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    private static final String IP_API_URL = "https://ipapi.co/{ip}/json/";

	    public SosMessage createLocationMessage(String location, String clientIp) {
	        SosMessage locationMessage = new SosMessage();

	        // Set current time
	        String currentTime = LocalDateTime.now().format(dateTimeFormatter);
	        locationMessage.setTime(currentTime);

	        // Determine location based on provided location or client IP
	        if (location != null && !location.isEmpty()) {
	            locationMessage.setLocation(location);
	        } else {
	            String ipAddress = clientIp != null ? clientIp : getLocalHostIp();
	            String inferredLocation = getLocationFromIp(ipAddress);
	            locationMessage.setLocation(inferredLocation != null ? inferredLocation : "Location not available");
	            locationMessage.setIpAddress(ipAddress);
	        }

	        // Construct the message
	        String message = "Message sent from location: " + locationMessage.getLocation() +
	                ", IP Address: " + locationMessage.getIpAddress() +
	                ", at time: " + locationMessage.getTime();
	        locationMessage.setMessage(message);

	        // Save the message to the database
	        return sosMessageRepository.save(locationMessage);
	    }

	    private String getLocalHostIp() {
	        try {
	            InetAddress localHost = InetAddress.getLocalHost();
	            return localHost.getHostAddress();
	        } catch (UnknownHostException e) {
	            return "IP address not available";
	        }
	    }

	    private String getLocationFromIp(String ipAddress) {
	        try {
	            String url = IP_API_URL.replace("{ip}", ipAddress);
	            Map<String, Object> response = restTemplate.getForObject(url, Map.class);

	            if (response != null && response.get("city") != null && response.get("country_name") != null) {
	                return response.get("city") + ", " + response.get("country_name");
	            }
	        } catch (Exception e) {
	            System.out.println("Error retrieving location: " + e.getMessage());
	        }
	        return null;
	    }
	}

	
	
	
	/*
	 * 
	 * 
    @Autowired
    private RestTemplate restTemplate;

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final String IP_API_URL = "https://ipapi.co/{ip}/json/";

    public SosMessage createLocationMessage(String location, String clientIp) {
        SosMessage locationMessage = new SosMessage();

        // Set current time
        String currentTime = LocalDateTime.now().format(dateTimeFormatter);
        locationMessage.setTime(currentTime);

        // Determine location based on provided location or client IP
        if (location != null && !location.isEmpty()) {
            locationMessage.setLocation(location);
        } else {
            String ipAddress = clientIp != null ? clientIp : getLocalHostIp();
            String inferredLocation = getLocationFromIp(ipAddress);
            locationMessage.setLocation(inferredLocation != null ? inferredLocation : "Location not available");
            locationMessage.setIpAddress(ipAddress);
        }

        // Construct the message
        String message = "Message sent from location: " + locationMessage.getLocation() +
                ", IP Address: " + locationMessage.getIpAddress() +
                ", at time: " + locationMessage.getTime();
        locationMessage.setMessage(message);

        return locationMessage;
    }

    private String getLocalHostIp() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            return localHost.getHostAddress();
        } catch (UnknownHostException e) {
            return "IP address not available";
        }
    }

    private String getLocationFromIp(String ipAddress) {
        try {
            // Call the external IP geolocation service
            String url = IP_API_URL.replace("{ip}", ipAddress);
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);

            if (response != null && response.get("city") != null && response.get("country_name") != null) {
                return response.get("city") + ", " + response.get("country_name");
            }
        } catch (Exception e) {
            System.out.println("Error retrieving location: " + e.getMessage());
        }
        return null;
    }
}*/
