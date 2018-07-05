package com.abdul.springprojects.configurator;

/**
 * Author Abdul Gafur D
 */

 
 
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.abdul.springprojects.serviceconfig.ServiceInvoker;
 

@Configuration
public class ApplicationConfigurator {
	
 
	@Bean
	public ServiceInvoker serviceInvoker() {
		return new ServiceInvoker();
	}
	
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
 
	
	 
 
}
