package com.abdul.springprojects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@EnableZuulProxy
@SpringBootApplication
public class SpringCloudZuulApp3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZuulApp3Application.class, args);
	}
}
