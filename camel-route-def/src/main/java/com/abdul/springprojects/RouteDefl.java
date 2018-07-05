package com.abdul.springprojects;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;

import org.apache.camel.model.RouteDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author abdul gafur
 *
 */
@Component
public class RouteDefl extends RouteBuilder {




    @Autowired
    private CamelContext context  ;


    String from = "file://in4?autoCreate=true";
    List<String> list = new ArrayList<>();
    String to1 = "file://out11?autoCreate=true";
    String to2 = "file://out21?autoCreate=true";
    String to3 = "file://out31?autoCreate=true";
    RouteDefinition routeDefinition = new RouteDefinition();



    public void createRoutes() throws Exception {

        BuildFromRoute(from);
        list.add(to1);  list.add(to2);  list.add(to3);

        for (String to : list) {
            System.out.println(to);
            BuildToRoute(to);
        }




    }


    public void BuildFromRoute(String from) throws Exception {

        this.routeDefinition.from(from);

    }


    public void BuildToRoute(String to) throws Exception {

        this.routeDefinition.to(to);

    }


	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		try {  
        createRoutes();
        context.addRouteDefinition(routeDefinition);


    } catch (Exception e) {
        e.printStackTrace();
    }
	}


    /*@Override
    public void configure() throws Exception {


        RouteDefinition routeDefinition = new RouteDefinition();

        RouteDefinition too = routeDefinition.from(from).to(to1);
        context.addRouteDefinition(too);

    }


    {
        try { list.add(to1); list.add(to2);list.add(to3);
            createRoutes(from,list);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/




}