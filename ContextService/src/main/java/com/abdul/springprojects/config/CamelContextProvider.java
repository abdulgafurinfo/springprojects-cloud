package com.abdul.springprojects.config;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelContextAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.abdul.springprojects.rest.CamelContextObject;

public class CamelContextProvider implements CamelContextAware {

	public static Logger logger = LoggerFactory.getLogger(CamelContextProvider.class);
    
	 
	protected CamelContext camelContext;
	
	@Autowired
	private CamelContextObject camelContextObject;
	

	@Override
	public void setCamelContext(CamelContext camelContext) {
		this.camelContext = camelContext;
		this.camelContextObject.setCamelContext(camelContext);
		logger.info("Global Manager Context : " + camelContext);
		logger.info("Global Manager Contextobj : " + camelContextObject.getCamelContext());

	}

	@Override
	public CamelContext getCamelContext() {
		logger.info("Global Manager Context : " + camelContext.getName());
		return camelContext;
	}

	public CamelContextObject getCamelContextObject() {
		return camelContextObject;
	}

	public void setCamelContextObject(CamelContextObject camelContextObject) {
		this.camelContextObject = camelContextObject;
	}

}
