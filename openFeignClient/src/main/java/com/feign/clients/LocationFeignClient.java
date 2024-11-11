package com.feign.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.feign.models.SosMessage;


@FeignClient(name = "location-service", url = "http://localhost:8092")
public class LocationFeignClient {

	
}
