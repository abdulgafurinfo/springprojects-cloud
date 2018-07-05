package com.abdul.springprojects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
 

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class EndPointBuilderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EndPointBuilderServiceApplication.class, args);
	}
}
