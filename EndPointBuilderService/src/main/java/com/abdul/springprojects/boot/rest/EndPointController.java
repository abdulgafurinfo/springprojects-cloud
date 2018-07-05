package com.abdul.springprojects.boot.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.abdul.springprojects.boot.feign.FeignServiceTemplate;
 

@RestController
@RequestMapping(value="/router")
public class EndPointController {
	
	
private static Logger log = LoggerFactory.getLogger(EndPointController.class);


@Autowired
private FeignServiceTemplate restTemplate;
	
	@RequestMapping(value="/service/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> addRoute(@PathVariable("id") String id,@RequestBody EndPointConfig endPointConfig){
		
		EndPointBuilder  endPointBuilder = new EndPointBuilder();
		log.info("I am into Camel manager using Put " + id);
		log.info(endPointConfig.toString());
		endPointBuilder.resolveEndPoint(endPointConfig);
		log.info("Created end point: "  + id);
	//	log.info(restTemplate.getCamelContextObject().getCamelContext().getName());
		try {
			restTemplate.getCamelContextObject().addRoutes(endPointBuilder);
		} catch (Exception e) {
			log.info("failed end point: "  + id);
			e.printStackTrace();
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
		
	}
	
	
	

}
