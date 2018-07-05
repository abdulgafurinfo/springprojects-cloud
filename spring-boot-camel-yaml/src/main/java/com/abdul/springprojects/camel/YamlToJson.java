package com.abdul.springprojects.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.dataformat.YAMLLibrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;

@Component
public class YamlToJson extends RouteBuilder {

	private static Logger logger = LoggerFactory.getLogger(YamlToJson.class);
	JacksonDataFormat jsonDataFormat = new JacksonDataFormat(EndPointConfig.class);
	 
	
	@Override
	public void configure() throws Exception {
		jsonDataFormat.disableFeature(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		jsonDataFormat.disableFeature(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);
		
		from("file:inyaml?autoCreate=true").choice().when(header("CamelFileName").endsWith(".yml")).unmarshal()
				.yaml(YAMLLibrary.SnakeYAML).log("${body}") // Yaml format
				.marshal(jsonDataFormat).log("${body}") // json format
				.end();

	}

}
