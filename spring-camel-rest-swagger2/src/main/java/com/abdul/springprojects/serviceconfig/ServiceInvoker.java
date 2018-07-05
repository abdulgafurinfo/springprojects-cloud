package com.abdul.springprojects.serviceconfig;

import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

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
	private Map<String, String> map = new LinkedHashMap<>();
	ServiceConfig serviceConf = new ServiceConfig();
	JavaPropsMapper mapper = new JavaPropsMapper(); 

    @Override
    public void configure() {
        restConfiguration().component("servlet").bindingMode(RestBindingMode.json);

        rest("/service").get().outType(ServiceConfig.class)
                .to("direct:invoke");
        
      //  restConfiguration().host("localhost").port(8124);
    	//restConfiguration().component("restlet").host("localhost").port(8124).bindingMode(RestBindingMode.auto);
        
        from("direct:invoke")
                .process(exchange -> {
                	ServiceConfig serviceConf = new ServiceConfig();
                	serviceConf.setServiceId("appid1");
                	serviceConf.setServiceName("testapp");
                	serviceConf.setSourcePath("mypath");
                	serviceConf.setTargetPath("mytarget");
                    exchange.getIn().setBody(serviceConf);
                });
        
        
    	 
        
        from("file:///C:/mydownloads/camel-test/input?move=.completed")
      //  .split(body().tokenize("\n"))
      //  .streaming()
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
        	   ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        	   String asText = ow.writeValueAsString(serviceConf);
        	   logger.info("converted");
        	   logger.info(asText);
        	
        })
        .to("servlet:post:api")
        
        ;
         
        
        
        
        
         }
         
    
    
    
    
}
