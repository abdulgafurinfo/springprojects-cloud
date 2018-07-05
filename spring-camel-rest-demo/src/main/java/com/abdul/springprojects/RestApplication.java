package com.abdul.springprojects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

 
/**
 * A Spring Boot application that starts the Camel routes.
 */
@SpringBootApplication
public class RestApplication {

    /**
     * A main method to start this application.
     */
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }
    
    
    @Bean
    public RestRoute restRoute() {
    	return new RestRoute();
    	
    }

}
 
