package com.abdul.springprojects.camel;

import java.io.InputStream;

import org.apache.camel.builder.RouteBuilder;

import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;

public class PropToJson extends RouteBuilder {

	ServiceConfig serviceConf = new ServiceConfig();
	JavaPropsMapper mapper = new JavaPropsMapper();

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub

		from("file:inprop?autoCreate=true").choice().when(header("CamelFileName").endsWith(".properties"))

				.process(exchange -> {

					InputStream input = exchange.getIn().getBody(InputStream.class);
					serviceConf = mapper.readValue(input, ServiceConfig.class);
					exchange.getIn().setBody(serviceConf);

				}).convertBodyTo(ServiceConfig.class).log("${body}")

		;

	}

}