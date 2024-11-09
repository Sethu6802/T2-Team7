package com.example.messageSystem.Controller;

import com.example.messageSystem.Service.LocationService;
import com.example.messageSystem.model.SosMessage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LocationController {

    @Autowired
    private final LocationService locationService;
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/sendMessage")
    public SosMessage sendMessage(
            @RequestParam(required = false) String location,
            @RequestHeader(value = "X-Forwarded-For", required = false) String clientIp) {

        return locationService.createLocationMessage(location, clientIp);
    }
    
    @GetMapping("/sendAllMessages")
    public List<SosMessage> fetchAllMessages()
    {
    	return locationService.getAllMessages();
    
    }
}
