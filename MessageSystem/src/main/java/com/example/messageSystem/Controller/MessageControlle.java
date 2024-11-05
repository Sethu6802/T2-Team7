//package com.example.messageSystem.Controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.messageSystem.Service.LocationService;
//import com.example.messageSystem.model.SosMessage;
//@RestController
//@RequestMapping("/message")
//public class MessageControlle {
//
//	 @Autowired
//	    private LocationService locationService;
//
//	    @GetMapping("/sendSosMessage")
//	    public SosMessage sendSosMessage(
//	            @RequestParam(required = false) String location,
//	            @RequestHeader(value = "X-Forwarded-For", required = false) String clientIp) {
//
//	        // Create an SOS message with location and IP
//	        return locationService.createLocationMessage(location, clientIp);
//	    }
//	}
