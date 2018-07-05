package com.abdul.springprojects.boot.rest;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author abdul gafur 
 *
 */

@Component
public class EndPointBuilder {

	@Autowired
	private EndPointObject endPointObject;

	List<String> targetEndPoint = null;
	LinkedHashMap<String, Object> fromEndPointParam = null;
	List<LinkedHashMap<String, Object>> toEndPointParam = null;

	int numOfEndPoints = 0;
	String serviceId = null;
	String fromEndPoint;
	List<String> toEndPoints = new LinkedList<String>();

	public void setConfig(EndPointConfig endPointConfig) {
        
		this.serviceId = endPointConfig.getServiceId();
		this.fromEndPointParam = endPointConfig.getFrom().getFirst();
		this.toEndPointParam = endPointConfig.getTo();
		this.numOfEndPoints = endPointConfig.getTo().size();
		this.fromEndPoint = CreateServiceEndPoint(this.fromEndPointParam);
		this.toEndPoints = CreateToEndPoints(this.toEndPointParam);
		this.endPointObject.setFromEndPoint(CreateServiceEndPoint(this.fromEndPointParam));
		this.endPointObject.setToEndPoints(CreateToEndPoints(this.toEndPointParam));
		this.endPointObject.setServiceId(endPointConfig.getServiceId());
		this.endPointObject.setNumOfEndPoints(endPointConfig.getTo().size());
	}

	public EndPointBuilder() {

	}

	public String CreateServiceEndPoint(LinkedHashMap<String, Object> endPointConfig) {

		String endPoint = endPointConfig.get("ServiceEndPoint") + "?" + getEndPointOptions(endPointConfig);

		return endPoint;

	}

	public List<String> CreateToEndPoints(List<LinkedHashMap<String, Object>> endPoints) {

		endPoints.forEach(endPoint -> {
			toEndPoints.add(CreateServiceEndPoint(endPoint));

		});

		return toEndPoints;
	}

	private String getEndPointOptions(LinkedHashMap<String, Object> endPointConfig) {
		// endPointConfig.remove("ServiceEndPoint");
		endPointConfig.forEach((k, v) -> {

			if (!"ServiceEndPoint".equals(k)) {

				fromEndPoint = k + "=" + v;
			}

		});

		return fromEndPoint;
	}

	public EndPointObject getEndPointObject() {
		return endPointObject;
	}

	public void setEndPointObject(EndPointObject endPointObject) {
		this.endPointObject = endPointObject;
	}

}
