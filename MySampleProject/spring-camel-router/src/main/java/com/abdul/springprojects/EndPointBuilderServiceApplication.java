package com.abdul.springprojects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.abdul.springprojects.boot.rest.EndPointBuilder;
import com.abdul.springprojects.boot.rest.EndPointObject;
 
/**
 * 
 * @author abdul gafur 
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class EndPointBuilderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EndPointBuilderServiceApplication.class, args);
	}
	
	@Bean
	public EndPointObject endPointObject() {
		
		return new EndPointObject();
	}
	
	
	@Bean
	public EndPointBuilder endPointBuilder() {
		
		return new EndPointBuilder();
	}
}
