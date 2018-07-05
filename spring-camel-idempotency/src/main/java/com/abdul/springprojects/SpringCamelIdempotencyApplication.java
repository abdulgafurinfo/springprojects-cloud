package com.abdul.springprojects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCamelIdempotencyApplication {

	public static void main(String[] args) throws Exception {
	 ApplicationContext context = 	SpringApplication.run(SpringCamelIdempotencyApplication.class, args);
	// RouteOrder order = (RouteOrder) context.getBean("routeOrder");
	// order.Start();
	}
}
