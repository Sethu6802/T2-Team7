package com.example.messageSystem.Service;

import org.springframework.stereotype.Service;

import com.example.messageSystem.model.SosMessage;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class LocationService {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public SosMessage createLocationMessage(String location, String clientIp) {
    	SosMessage locationMessage = new SosMessage();

        // Set current time
        String currentTime = LocalDateTime.now().format(dateTimeFormatter);
        locationMessage.setTime(currentTime);

        // Set location and IP address
        if (location != null && !location.isEmpty()) {
            locationMessage.setLocation(location);
        } else {
            String ipAddress = clientIp != null ? clientIp : getLocalHostIp();
            locationMessage.setLocation("Location not provided. Using IP address instead.");
            locationMessage.setIpAddress(ipAddress);
        }

        // Construct message
        String message = "Message sent from location: " + locationMessage.getLocation() +
                ", IP Address: " + (clientIp != null ? clientIp : locationMessage.getIpAddress()) +
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
}

//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import com.example.messageSystem.model.SosMessage;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Map;
//
//@Service
//public class LocationService {
//
//    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//    private static final String IP_API_URL = "http://ip-api.com/json/";
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    public SosMessage createLocationMessage(String location, String clientIp) {
//    	SosMessage locationMessage = new SosMessage();
//
//        // Set current time
//        String currentTime = LocalDateTime.now().format(dateTimeFormatter);
//        locationMessage.setTime(currentTime);
//
//        // Determine location
//        if (location != null && !location.isEmpty()) {
//            locationMessage.setLocation(location);
//        } else {
//            String ipAddress = clientIp != null ? clientIp : getLocalHostIp();
//            locationMessage.setIpAddress(ipAddress);
//
//            // Debugging: Print IP Address
//            System.out.println("Using IP Address for location: " + ipAddress);
//
//            // Get location automatically from IP address using IP-API
//            String autoLocation = fetchLocationFromIp(ipAddress);
//            locationMessage.setLocation(autoLocation != null ? autoLocation : "Location not available");
//        }
//
//        // Construct message
//        String message = "Message sent from location: " + locationMessage.getLocation() +
//                ", IP Address: " + locationMessage.getIpAddress() +
//                ", at time: " + locationMessage.getTime();
//        locationMessage.setMessage(message);
//
//        return locationMessage;
//    }
//
//    // Fetches location based on IP address using IP-API
//    private String fetchLocationFromIp(String ipAddress) {
//        try {
//            String url = IP_API_URL + ipAddress;
//            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
//
//            // Debugging: Print API response
//            System.out.println("Response from IP-API: " + response);
//
//            if (response != null && "success".equals(response.get("status"))) {
//                String city = (String) response.get("city");
//                String region = (String) response.get("regionName");
//                String country = (String) response.get("country");
//
//                return city + ", " + region + ", " + country;
//            } else {
//                System.err.println("Failed to get location from IP-API. Response: " + response);
//            }
//        } catch (Exception e) {
//            System.err.println("Error fetching location from IP-API: " + e.getMessage());
//        }
//        return null;
//    }
//
//    // Helper method to get local host IP if client IP is not available
//    private String getLocalHostIp() {
//        try {
//            InetAddress localHost = InetAddress.getLocalHost();
//            return localHost.getHostAddress();
//        } catch (UnknownHostException e) {
//            System.err.println("Error getting local host IP: " + e.getMessage());
//            return "IP address not available";
//        }
//    }
//}

//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import com.example.messageSystem.model.SosMessage;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Map;
//
//@Service
//public class LocationService {
//
//    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//    private static final String IP_API_URL = "http://ip-api.com/json/";
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    public SosMessage createLocationMessage(String location, String clientIp) {
//    	SosMessage locationMessage = new SosMessage();
//
//        // Set current time
//        String currentTime = LocalDateTime.now().format(dateTimeFormatter);
//        locationMessage.setTime(currentTime);
//
//        // Determine location
//        if (location != null && !location.isEmpty()) {
//            locationMessage.setLocation(location);
//        } else {
//            String ipAddress = clientIp != null ? clientIp : getLocalHostIp();
//            locationMessage.setIpAddress(ipAddress);
//
//            // Debugging: Print IP Address
//            System.out.println("Using IP Address for location: " + ipAddress);
//
//            // Get location automatically from IP address using IP-API
//            String autoLocation = fetchLocationFromIp(ipAddress);
//            locationMessage.setLocation(autoLocation != null ? autoLocation : "Location not available");
//        }
//
//        // Construct message
//        String message = "Message sent from location: " + locationMessage.getLocation() +
//                ", IP Address: " + locationMessage.getIpAddress() +
//                ", at time: " + locationMessage.getTime();
//        locationMessage.setMessage(message);
//
//        return locationMessage;
//    }
//
//    // Fetches location based on IP address using IP-API
//    private String fetchLocationFromIp(String ipAddress) {
//        try {
//            String url = IP_API_URL + ipAddress;
//            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
//
//            // Debugging: Print API response
//            System.out.println("Response from IP-API: " + response);
//
//            if (response != null && "success".equals(response.get("status"))) {
//                String city = (String) response.get("city");
//                String region = (String) response.get("regionName");
//                String country = (String) response.get("country");
//
//                return city + ", " + region + ", " + country;
//            } else {
//                System.err.println("Failed to get location from IP-API. Response: " + response);
//            }
//        } catch (Exception e) {
//            System.err.println("Error fetching location from IP-API: " + e.getMessage());
//        }
//        return null;
//    }
//
//    // Helper method to get local host IP if client IP is not available
//    private String getLocalHostIp() {
//        try {
//            InetAddress localHost = InetAddress.getLocalHost();
//            return localHost.getHostAddress();
//        } catch (UnknownHostException e) {
//            System.err.println("Error getting local host IP: " + e.getMessage());
//            return "IP address not available";
//        }
//    }
//}


