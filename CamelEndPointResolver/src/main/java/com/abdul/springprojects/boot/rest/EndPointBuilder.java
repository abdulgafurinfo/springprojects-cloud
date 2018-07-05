package com.abdul.springprojects.boot.rest;

import java.util.List;

import org.apache.camel.builder.RouteBuilder;

public class EndPointBuilder extends RouteBuilder{
	
	
	String fileEndPoint =null;
	List<String> targetEndPoint=null;
	ServiceConfig serviceConfig =null;
	
	public  boolean resolve(ServiceConfig serviceConfig) {
		this.serviceConfig = serviceConfig;
		this.fileEndPoint = remoteEndPoint(serviceConfig);
		
		return false;
		
		
	}
	

	public String  remoteEndPoint(ServiceConfig serviceConfig) {
		
	    fileEndPoint = serviceConfig.getRemoteEndPoint()
	    		   + ":"
	    		   + serviceConfig.getRemoteDir()
	    		   + "?"
	               + "autoCreate=true";
		return fileEndPoint;
		
		
	}
	
	
public String  targetEndPoints(ServiceConfig serviceConfig) {
		
	if(serviceConfig.getTargetType().contains("amqp")) {
		
		 
	}
	     
		return fileEndPoint;
		
		
	}





	@Override
	public void configure() throws Exception {
	 
		from(fileEndPoint) 
		.log("{body}")
		.to("direct:service")
		 .routeId(serviceConfig.getServiceId());
	}


	public String getFileEndPoint() {
		return fileEndPoint;
	}


	public void setFileEndPoint(String fileEndPoint) {
		this.fileEndPoint = fileEndPoint;
	}
	

}
