package com.abdul.springprojects.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abdul.springprojects.serviceconfig.ServiceConfig;
 

@RestController

public class ServiceController {
	
	public static Logger logger = LoggerFactory.getLogger(ServiceController.class);
	
	
	@RequestMapping(value="/api/", method=RequestMethod.POST)
	public ResponseEntity<Void> createRequest(@RequestBody ServiceConfig serviceConfig){
		
		logger.info("Tryying to create a request");
		logger.info(serviceConfig.getServiceId());
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
		
	}




}
