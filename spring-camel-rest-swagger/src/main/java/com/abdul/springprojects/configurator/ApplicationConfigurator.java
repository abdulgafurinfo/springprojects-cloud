package com.abdul.springprojects.configurator;

/**
 * Author Abdul Gafur D
 */

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.component.swagger.DefaultCamelSwaggerServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

 
import com.abdul.springprojects.serviceconfig.ServiceInvoker;

@Configuration
public class ApplicationConfigurator {
	
	private static final String URL_MAPPING = "/service/*";
    private static final String SERVLET_NAME = "CamelServlet";
	
	
	@Bean
	public ServiceInvoker serviceInvoker() {
		return new ServiceInvoker();
	}
	
	
	@Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean registration =
                new ServletRegistrationBean(new CamelHttpTransportServlet(), URL_MAPPING);
        registration.setName(SERVLET_NAME);
        return registration;
    }

    @Bean
    public ServletRegistrationBean swaggerServlet() {
        ServletRegistrationBean swagger = new ServletRegistrationBean(new DefaultCamelSwaggerServlet(), "/api-doc/*");
        Map<String, String> params = new HashMap<>();
        params.put("base.path", "api");
        params.put("api.title", "Dynamic service Invoker");
        params.put("api.description", "Camel Dynamic Path adder");
        params.put("api.termsOfServiceUrl", "termsOfServiceUrl");
        params.put("api.license", "license");
        params.put("api.licenseUrl", "licenseUrl");
        swagger.setInitParameters(params);
        return swagger;
    }
	

}
