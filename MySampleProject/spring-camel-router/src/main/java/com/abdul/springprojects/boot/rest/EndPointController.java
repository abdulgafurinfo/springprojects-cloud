package com.abdul.springprojects.boot.rest;

import org.apache.camel.CamelContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/router")
public class EndPointController {

	private static Logger logger = LoggerFactory.getLogger(EndPointController.class);

	@Autowired
	private CamelContext context;

	@Autowired
	private EndPointObject endPointObject;

	@Autowired
	private EndPointBuilder endPointBuilder;

	@RequestMapping(value = "/service", method = RequestMethod.PUT)
	public ResponseEntity<Void> addRoute(@RequestBody EndPointConfig endPointConfig) {
		endPointBuilder.setConfig(endPointConfig);

		try {
			context.addRoutes(new MultiDynamicRouteBuilder(context, endPointObject));
		} catch (Exception e) {
			logger.error("Failed to create routes");
			e.printStackTrace();
		}
		logger.info("Routes added sucessfully");
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

}
