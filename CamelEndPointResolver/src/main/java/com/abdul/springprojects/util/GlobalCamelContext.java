package com.abdul.springprojects.util;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelContextAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
 

 

 
public class GlobalCamelContext implements CamelContextAware {
	
	public static Logger logger = LoggerFactory.getLogger(GlobalCamelContext.class);
	
	@Autowired
	protected CamelContext camelContext;

	@Override
	public void setCamelContext(CamelContext camelContext) {
		// TODO Auto-generated method stub
		this.camelContext=camelContext;
		
	}

	@Override
	public CamelContext getCamelContext() {
		logger.info("Global Manager Context : " + camelContext.getName()); 
		return camelContext;
	}

}
