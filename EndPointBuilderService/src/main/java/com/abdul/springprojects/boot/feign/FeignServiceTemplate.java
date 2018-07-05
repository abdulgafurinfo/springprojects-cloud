package com.abdul.springprojects.boot.feign;

import org.apache.camel.CamelContext;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abdul.springprojects.boot.rest.CamelContextObject;

 

@FeignClient("camel-context-provider")
 
public interface FeignServiceTemplate {
	
	

	 @RequestMapping(value="/contextObject")	 
     public CamelContext getCamelContextObject();
	
	 
}
