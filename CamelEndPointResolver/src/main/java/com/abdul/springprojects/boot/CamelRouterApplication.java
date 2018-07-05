package com.abdul.springprojects.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.abdul.springprojects.util.GlobalCamelContext;

@SpringBootApplication
public class CamelRouterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamelRouterApplication.class, args);
	}
	
	
	@Bean
	public GlobalCamelContext camelInvoker() {
		return new GlobalCamelContext();
	}
	
	
}
