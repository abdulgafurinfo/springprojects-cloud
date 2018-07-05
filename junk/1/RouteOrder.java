package com.abdul.springprojects;

import org.apache.camel.CamelContext;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

 
public class RouteOrder {
	
	@Autowired
	private CamelContext context;
	
	private Logger logger = LogManager.getLogger(RouteOrder.class);
	
	public void Start() throws Exception {
		context.startRoute("print");
		logger.info(context.getRoutes().toString());
	}
	
	
	

}
