package com.abdul.springprojects.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.dataformat.YAMLLibrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JsonToYaml extends RouteBuilder {

	private static Logger logger = LoggerFactory.getLogger(YamlToJson.class);
//	JacksonDataFormat jsonDataFormat = new JacksonDataFormat(EndPointConfig.class);
	@Override
	public void configure() throws Exception {
		
		from("file:injson?autoCreate=true").choice().when(header("CamelFileName").endsWith(".json"))
		.unmarshal()
		.json(JsonLibrary.Jackson, true)
	//	.log("${body}") // json format
		.marshal()
		.yaml(YAMLLibrary.SnakeYAML).log("${body}") // Yaml format
		.end();
		
	}

	
	
}
