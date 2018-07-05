package com.abdul.springprojects.rest;

 
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.abdul.springprojects.serviceconfig.EndPointConfig;
 

 

@RestController
public class ServiceController {

	public static Logger logger = LoggerFactory.getLogger(ServiceController.class);

	@Autowired
	private RestTemplate restTemplate;

	private String url = "http://localhost:9000/router/service";

	private Map<String, String> urlParams = new HashMap<String, String>();

	@RequestMapping(value = "/api/service", method = RequestMethod.PUT)
	public boolean createRequest(@RequestHeader("Content-Type") String contentType,
			@RequestBody EndPointConfig endPointConfig) {
		
		
		logger.info(contentType.toString());
		logger.info(endPointConfig.toString());
		logger.info(endPointConfig.getServiceId());
		logger.info(endPointConfig.from.toString());
		logger.info(endPointConfig.to.toString());
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		urlParams.put("serviceId", endPointConfig.getServiceId());
		HttpEntity<EndPointConfig> requestEntity = new HttpEntity<EndPointConfig>(endPointConfig, headers);
		//restTemplate.exchange(url, HttpMethod.PUT, requestEntity, EndPointConfig.class, urlParams);
		restTemplate.exchange(url, HttpMethod.PUT, requestEntity, EndPointConfig.class);
		logger.info("Successfully created a request");
		return new ResponseEntity<Void>(HttpStatus.CREATED) != null;

	}

}
