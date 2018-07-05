package com.abdul.springprojects;

import java.util.Date;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.camel.processor.idempotent.FileIdempotentRepository;
import org.apache.camel.routepolicy.quartz.SimpleScheduledRoutePolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileIdempotentConsumer extends RouteBuilder {

	@Autowired
	public FileIdempotentRepository fileIdempotentRepository;
	
	@Autowired
	public FilePollerReport filePollerReport;
	
	 
	@Autowired
	public CamelContext context;
 
	
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub   
		
	//	String fileRepo = fileIdempotentRepository.getFileStore().toString();
	//	SimpleScheduledRoutePolicy policy = new SimpleScheduledRoutePolicy();
		 
	//   FilePollerReport report = new FilePollerReport();
	   
	   
	   SimpleScheduledRoutePolicy policy = new SimpleScheduledRoutePolicy();
	   long startTime = System.currentTimeMillis();
	   policy.setRouteStartDate(new Date(startTime));
	   policy.setRouteStartRepeatCount(1);
	   policy.setRouteStartRepeatInterval(30);
	   
	    
	    // tell Camel to use our SimpleRegistry
	   // context = new DefaultCamelContext(registry)
	    
	    
		from("file://input?noop=true")  
		   
	 //  .log("Number of files polled in : ${header.CamelBatchSize}")
	//   .onCompletion().onWhen(simple("${header.CamelBatchComplete} == true")) 
	 //  . onWhen(simple("${header.CamelBatchComplete} == true")) 
	//   .log("Number of files polled in : ${header.CamelBatchSize}")
	 //  .log("Inserting into file store...")
	 //  .log("Number of files polled in : ${header.CamelBatchSize}")
	 //for /l %f in (1,1,100) do copy 1.txt %f.txt
	   	.setHeader("numOfInFiles", simple("${header.CamelBatchSize}"))
	    .setHeader("fileStore", simple(fileIdempotentRepository.getFileStore().toString()))
		 .bean(filePollerReport,"setNewFiles(${header.numOfInFiles})")
		 .bean(filePollerReport,"setOldFiles(${header.fileStore})")
	   .idempotentConsumer(simple("${file:name}"), fileIdempotentRepository)
	//   .eager(true)
	  // .log("Inserting into output and marked as complete...")
	   .to("file://output")
	       
	/*   .setHeader("numOfInFiles", simple("${header.CamelBatchSize}"))
	   .setHeader("fileStore", fileRepo)*/
	  // .setHeader("numOfInFiles", simple("${header.CamelBatchSize}"))
	 //  .setHeader("fileStore", simple(fileIdempotentRepository.getFileStore().toString()))
	   .log("Inserting into output and marked as complete...")
	   .setHeader("fileStore", simple(fileIdempotentRepository.getFileStore().toString()))
	   .bean(filePollerReport,"setOldFiles(${header.fileStore})")
	  // .startupOrder(1)
	//   .to("direct:start1")  
	   
	   
	   ;   
		
	/*	from("timer://foo?fixedRate=true&period=60000"
	//	 .startupOrder(2)
		 .autoStartup("false")
		 .routeId("print")
		 .routePolicy(policy)
		 .log("Iprint  complete...")
	    .to("bean:report?method=printReport");
		 //.bean(report,"printReport");
		  * 
		  * 
		  * 
*/		
		
		
		  
		
	//	context.startRoute("print");
		
		 	from("timer://foo?fixedRate=true&period=6000")
		 	 .startupOrder(2)
			// .autoStartup("false")
			// .routeId("print")
			// .routePolicy(policy)
			 .log("Iprint  complete...")
			  .setHeader("fileStore", simple(fileIdempotentRepository.getFileStore().toString()))
			   .bean(filePollerReport,"setOldFiles(${header.fileStore})")
			 .bean(filePollerReport,"printReport");
		  //  .to("bean:filePollerReport?method=printReport");
		 	
		 	
		 	 
		 
	}

}
