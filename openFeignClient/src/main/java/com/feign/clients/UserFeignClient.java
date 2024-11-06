package com.feign.clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "user-service", url = "http://localhost:9078")
public class UserFeignClient {

}
