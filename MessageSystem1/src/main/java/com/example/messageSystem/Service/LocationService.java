package com.example.messageSystem.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.messageSystem.model.SosMessage;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
public class LocationService {

    @Autowired
    private RestTemplate restTemplate;

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final String IP_API_URL = "https://ipapi.co/{ip}/json/";

    public SosMessage createLocationMessage(String location, String clientIp) {
        SosMessage locationMessage = new SosMessage();
        
        String currentTime = LocalDateTime.now().format(dateTimeFormatter);
        locationMessage.setTime(currentTime);

        if (location != null && !location.isEmpty()) {
            locationMessage.setLocation(location);
        } else {
            String ipAddress = clientIp != null ? clientIp : getExternalIp();
            String inferredLocation = getLocationFromIp(ipAddress);
            locationMessage.setLocation(inferredLocation != null ? inferredLocation : "Location not available");
            locationMessage.setIpAddress(ipAddress);
        }

        String message = "Message sent from location: " + locationMessage.getLocation() +
                ", IP Address: " + locationMessage.getIpAddress() +
                ", at time: " + locationMessage.getTime();
        locationMessage.setMessage(message);

        return locationMessage;
    }

    
    private String getExternalIp() {
        try {
            String url = "https://api.ipify.org";
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            return "Unable to retrieve external IP";
        }
    }

    private String getLocalHostIp() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            String hostAddress = localHost.getHostAddress();

            if (hostAddress.equals("127.0.0.1") || hostAddress.equals("::1")) {
                return "8.8.8.8";
            }

            return hostAddress;
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
