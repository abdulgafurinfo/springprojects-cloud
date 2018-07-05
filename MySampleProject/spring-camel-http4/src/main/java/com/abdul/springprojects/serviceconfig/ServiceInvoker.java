package com.abdul.springprojects.serviceconfig;

import java.io.InputStream;

import org.apache.camel.Exchange;

/**
 * Author Abdul Gafur D
 */

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.dataformat.YAMLLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.DeserializationFeature;

public class ServiceInvoker extends RouteBuilder {

	public static Logger logger = LoggerFactory.getLogger(ServiceInvoker.class);
 
	JacksonDataFormat jsonDataFormat = new JacksonDataFormat(EndPointConfig.class);

	@Override
	public void configure() {

	//	restConfiguration().host("localhost").port("8080").bindingMode(RestBindingMode.json);
		jsonDataFormat.disableFeature(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		jsonDataFormat.disableFeature(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);

		from("file:inyaml?autoCreate=true").choice().when(header("CamelFileName").endsWith(".yml")).unmarshal()
				.yaml(YAMLLibrary.SnakeYAML).log("${body}") // Yaml format
				.marshal(jsonDataFormat).log("${body}") // json format
				.setHeader(Exchange.HTTP_METHOD, constant(org.apache.camel.component.http4.HttpMethods.PUT))
				//http4:hostname[:port][/resourceUri][?options]
				.to("http4:localhost:8999/api/service");
			//	.endRest();

		
		
		
	 

	}

}
