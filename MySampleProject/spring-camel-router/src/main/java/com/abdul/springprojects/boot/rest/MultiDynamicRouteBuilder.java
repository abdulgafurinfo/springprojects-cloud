package com.abdul.springprojects.boot.rest;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;

import org.apache.camel.model.RouteDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import java.util.List;

 /**
  * 
  * @author abdul gafur 
  *
  */
public class MultiDynamicRouteBuilder extends RouteBuilder {

	private static Logger logger = LoggerFactory.getLogger(MultiDynamicRouteBuilder.class);
	private CamelContext context  ;
    
    private EndPointObject endPointObject  ;


    
    RouteDefinition routeDefinition = new RouteDefinition();
    
    
    MultiDynamicRouteBuilder(CamelContext context,EndPointObject endPointObject){
    	this.context = context;
    	this.endPointObject = endPointObject;
    	
    }

     
    private void createRoutes() {
	    String from = 	endPointObject.getFromEndPoint();
	    logger.info(from);
	    List<String> toList = endPointObject.getToEndPoints();
		buildFromRoute(from);
		
		toList.forEach(to->{
			buildToRoute(to);
			
		});
		
	}


	 

	private void buildToRoute(String to) {
		 logger.info(to);
		 this.routeDefinition.to(to);
		
	}

	private void buildFromRoute(String from) {
		this.routeDefinition.from(from);
		
	}

	@Override
	public void configure() throws Exception {
	 
		if(null!= this.endPointObject) {
			
			try {  
		        createRoutes();
		        context.addRouteDefinition(routeDefinition);


		    } catch (Exception e) {
		        e.printStackTrace();
		    }
			
		}
		
		
	}





}