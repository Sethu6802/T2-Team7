package com.feign.clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "hosp-service", url = "http://localhost:8096")
public class HospitalFeignClient {

}
