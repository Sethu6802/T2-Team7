package com.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@ComponentScan({"com.example.messageSystem"})
public class OpenFeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenFeignClientApplication.class, args);
	}

}
