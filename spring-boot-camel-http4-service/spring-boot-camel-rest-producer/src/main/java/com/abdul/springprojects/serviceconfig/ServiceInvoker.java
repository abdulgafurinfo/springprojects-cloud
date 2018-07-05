package com.abdul.springprojects.serviceconfig;

import java.io.InputStream;

/**
 * Author Abdul Gafur D
 */

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;

public class ServiceInvoker extends RouteBuilder {

	public static Logger logger = LoggerFactory.getLogger(ServiceInvoker.class);
	ServiceConfig serviceConf = new ServiceConfig();
	JavaPropsMapper mapper = new JavaPropsMapper();

	@Override
	public void configure() {

		restConfiguration().host("localhost").port("8080").bindingMode(RestBindingMode.json);

		from("file:" + "serviceconfig" + "?" + "autoCreate=true")

				.process(exchange -> {

					InputStream input = exchange.getIn().getBody(InputStream.class);
					serviceConf = mapper.readValue(input, ServiceConfig.class);
					exchange.getIn().setBody(serviceConf);

				}).convertBodyTo(ServiceConfig.class)
				   .to("rest:put:api/service")
				   .endRest()

		;

	}

}
