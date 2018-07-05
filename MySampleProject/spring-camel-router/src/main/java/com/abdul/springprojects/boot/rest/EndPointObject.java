package com.abdul.springprojects.boot.rest;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * 
 * @author abdul gafur 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndPointObject {
	
	private static Logger logger = LoggerFactory.getLogger(EndPointObject.class);
	
	int numOfEndPoints = 0;
	String serviceId = null;
	String fromEndPoint;
	List<String> toEndPoints = new LinkedList<String>();
	
	
	
	public int getNumOfEndPoints() {
		return numOfEndPoints;
	}
	public void setNumOfEndPoints(int numOfEndPoints) {
		this.numOfEndPoints = numOfEndPoints;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getFromEndPoint() {
		return fromEndPoint;
	}
	public void setFromEndPoint(String fromEndPoint) {
		this.fromEndPoint = fromEndPoint;
	}
	public List<String> getToEndPoints() {
		return toEndPoints;
	}
	public void setToEndPoints(List<String> toEndPoints) {
		this.toEndPoints = toEndPoints;
	}

}
