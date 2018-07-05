package com.abdul.springprojects.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleAMQPRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("activemq:myqueue")
            .to("log:sample");

        from("timer:mytimer")
            .setBody(constant("Test route from Camel and Spring boot"))
            .to("activemq:myqueue");
    }

    
}