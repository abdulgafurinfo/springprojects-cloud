package com.abdul.springprojects.boot.feign;

import org.apache.camel.CamelContext;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abdul.springprojects.boot.rest.EndPointObject;
 

 

@FeignClient("camel-context-provider")
@RequestMapping("/camel")
public interface FeignServiceTemplate {
	
	

	@RequestMapping(value = "/addRoute", method = RequestMethod.PUT)
	public String createRoute(@RequestBody EndPointObject endPointObject);
	
	 
}
