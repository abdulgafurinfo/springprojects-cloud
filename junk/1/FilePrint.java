package com.abdul.springprojects;

import java.util.Date;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.routepolicy.quartz.SimpleScheduledRoutePolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

 
public class FilePrint extends RouteBuilder {
	
	 
	@Autowired
	public FilePollerReport report;
	

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		SimpleScheduledRoutePolicy policy = new SimpleScheduledRoutePolicy();
		long startTime = System.currentTimeMillis() + 3000L;
		policy.setRouteStartDate(new Date(startTime));
		policy.setRouteStartRepeatCount(1);
		policy.setRouteStartRepeatInterval(3000);
		   
		from("direct:start1")
	 
		 .autoStartup("false")
		 .routeId("print")
		 .routePolicy(policy)
		 .log("Iprint  complete...")
	    .to("bean:report?method=printReport");
		 
		
	}

}