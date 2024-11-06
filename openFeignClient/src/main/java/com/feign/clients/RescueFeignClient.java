package com.feign.clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "rescue-service", url = "http://localhost:8094")
public class RescueFeignClient {

}
