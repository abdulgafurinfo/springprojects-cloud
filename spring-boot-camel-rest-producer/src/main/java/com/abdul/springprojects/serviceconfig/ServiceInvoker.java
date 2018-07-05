package com.abdul.springprojects.serviceconfig;

 
import java.io.InputStream;
 

 
/**
 * Author Abdul Gafur D
 */

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;
 

 
public class ServiceInvoker extends RouteBuilder {
	
	public static Logger logger = LoggerFactory.getLogger(ServiceInvoker.class);
	ServiceConfig serviceConf = new ServiceConfig();
	JavaPropsMapper mapper = new JavaPropsMapper(); 

    @Override
    public void configure() {
    	
    	restConfiguration()
        .host("localhost").port("8080")
       .bindingMode(RestBindingMode.json);
        
    	 

       /* from("timer:hello?period={{timer.period}}")
        .setBody(simple("${random(1,3)}"))
        .convertBodyTo(String.class)
        .to("rest:post:api");*/
        
        
        
        from("file:in?autoCreate=true")
      //  .split(body().tokenize("\n"))
      //  .streaming()  C:\cameltest\input
        .process(exchange -> {
        //	String input = exchange.getIn().getBody(String.class);
      //  	InputStream input = exchange.getIn().getBody(InputStream.class);
       // 	List<String> list = Arrays.asList(input.split("="));
       // 	map.put(list.get(0), list.get(1));
        	/*ObjectMapper objectMapper = new ObjectMapper();
        	serviceConf = objectMapper.readValue(input, ServiceConfig.class);         	 
            exchange.getIn().setBody(serviceConf);*/
        	
        	InputStream input = exchange.getIn().getBody(InputStream.class);
        	serviceConf = mapper.readValue(input, ServiceConfig.class);
        	exchange.getIn().setBody(serviceConf);
        	
        	/**
        	 * log here for testing only
        	 */
        	   /*ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        	   String asText = ow.writeValueAsString(serviceConf);
        	   logger.info("converted");
        	   logger.info(asText);*/
        	
        })
   //     .setBody(${body})
       
      
      .convertBodyTo(ServiceConfig.class)
     // '' .convertBodyTo(String.class)
        
        .to("rest:post:api")
        
        ;
         
        
        
        
        
         }
         
    
    
    
    
}
