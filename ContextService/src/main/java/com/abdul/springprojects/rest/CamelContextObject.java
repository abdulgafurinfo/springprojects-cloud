package com.abdul.springprojects.rest;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CamelContextObject {
	
	 @Autowired
	 private CamelContext camelContext;

	public CamelContext getCamelContext() { 
		return camelContext;
	}

	public void setCamelContext(CamelContext camelContext) {
		this.camelContext = camelContext;   
		 
	}

	@Override
	public String toString() {
		return "CamelContextObject [camelContext=" + camelContext + "]";
	}

}
