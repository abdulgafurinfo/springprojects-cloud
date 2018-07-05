package com.abdul.springprojects.serviceconfig;

/**
 * Author Abdul Gafur D
 */

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
 

 
public class ServiceInvoker extends RouteBuilder {

    @Override
    public void configure() {
        restConfiguration().component("servlet").bindingMode(RestBindingMode.json);

        rest("/service").get().outType(ServiceConfig.class)
                .to("direct:invoke");
        
        from("direct:invoke")
                .process(exchange -> {
                	ServiceConfig serviceConf = new ServiceConfig();
                	serviceConf.setServiceId("appid1");
                	serviceConf.setServiceName("testapp");
                	serviceConf.setSourcePath("mypath");
                	serviceConf.setTargetPath("mytarget");
                    exchange.getIn().setBody(serviceConf);
                });
    }
}
