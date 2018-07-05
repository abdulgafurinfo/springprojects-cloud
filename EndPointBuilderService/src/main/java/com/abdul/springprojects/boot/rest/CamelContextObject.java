package com.abdul.springprojects.boot.rest;

import org.apache.camel.CamelContext;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CamelContextObject {
	
	
	 private CamelContext camelContext;

	public CamelContext getCamelContext() {
		return camelContext;
	}

	public void setCamelContext(CamelContext camelContext) {
		this.camelContext = camelContext;
		 
	}

}
