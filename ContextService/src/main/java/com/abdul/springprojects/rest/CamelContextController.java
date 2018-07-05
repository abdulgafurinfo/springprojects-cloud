package com.abdul.springprojects.rest;

import org.apache.camel.CamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abdul.springprojects.config.CamelContextProvider;

@RestController
//@RequestMapping("camel")
public class CamelContextController {
	
	public static Logger logger = LoggerFactory.getLogger(CamelContextController.class);
	
	@Autowired
	private CamelContext camelContext;
	
	/* @RequestMapping(value="/contextObject", method=RequestMethod.GET,
	            produces="application/json")	*/
	 @RequestMapping(value="/contextObject" )	
	 public CamelContext getCamelContextObject() {     
		 //logger.info("gett context object" + camelContextProvider.getCamelContextObject().toString());         
		 return camelContext;
		 
	 }
	

}
