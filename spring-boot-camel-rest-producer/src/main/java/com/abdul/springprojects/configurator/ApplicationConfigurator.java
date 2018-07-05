package com.abdul.springprojects.configurator;

/**
 * Author Abdul Gafur D
 */

import java.util.HashMap;
import java.util.Map;
 
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

 
import com.abdul.springprojects.serviceconfig.ServiceInvoker;

@Configuration
public class ApplicationConfigurator {
	
	 
    
	
	@Bean
	public ServiceInvoker serviceInvoker() {
		return new ServiceInvoker();
	}
	
	 
  
	 
	 
	
	 
	

}
