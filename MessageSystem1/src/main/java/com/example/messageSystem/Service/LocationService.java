package com.example.messageSystem.Service;

import com.example.messageSystem.Repository.sosRepo;
import com.example.messageSystem.model.SosMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class LocationService {

    @Autowired
    private sosRepo repo;

    @Autowired
    private ExternalApiService externalApiService;

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

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

        repo.save(locationMessage);

        return locationMessage;
    }

    private String getExternalIp() {
        return externalApiService.getExternalIp()
                .block();
    }

    private String getLocationFromIp(String ipAddress) {
        return externalApiService.getLocationFromIp(ipAddress)
                .block();
    }
    
    public List<SosMessage> getAllMessages()
    {
    	return repo.findAll();
    }
}
