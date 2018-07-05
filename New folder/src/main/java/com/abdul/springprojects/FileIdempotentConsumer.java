package com.abdul.springprojects;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.idempotent.FileIdempotentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileIdempotentConsumer extends RouteBuilder {

	@Autowired
	public FileIdempotentRepository fileIdempotentRepository;
	
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		String fileRepo = fileIdempotentRepository.getFileStore().toString();
		
		from("file://input?noop=true")  
		   
	 //  .log("Number of files polled in : ${header.CamelBatchSize}")
	//   .onCompletion().onWhen(simple("${header.CamelBatchComplete} == true")) 
	 //  . onWhen(simple("${header.CamelBatchComplete} == true")) 
	//   .log("Number of files polled in : ${header.CamelBatchSize}")
	 //  .log("Inserting into file store...")
	 //  .log("Number of files polled in : ${header.CamelBatchSize}")
	 //for /l %f in (1,1,100) do copy 1.txt %f.txt
	   .idempotentConsumer(simple("${file:name}"), fileIdempotentRepository)
	   .eager(true)
	   .log("Inserting into output and marked as complete...")
	   .to("file://output")
	       
	/*   .setHeader("numOfInFiles", simple("${header.CamelBatchSize}"))
	   .setHeader("fileStore", fileRepo)*/
	   .setHeader("numOfInFiles", simple("${header.CamelBatchSize}"))
	   .setHeader("fileStore", simple(fileIdempotentRepository.getFileStore().toString()))
	   .process(new FilePollerReport())
	   
	   ;   
		
		/*from("direct:start")
		.bean(beanType)*/
		
	}

}
