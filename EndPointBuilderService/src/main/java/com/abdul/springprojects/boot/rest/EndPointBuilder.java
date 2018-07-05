package com.abdul.springprojects.boot.rest;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
 

import org.apache.camel.builder.RouteBuilder;

public class EndPointBuilder extends RouteBuilder {

	List<String> targetEndPoint = null;
	LinkedHashMap<String, Object> fromEndPointParam = null;
	List<LinkedHashMap<String, Object>> toEndPointParam = null;
	int numOfEndPoints = 0;
	String serviceId = null;
	String fromEndPoint;
	List<String> toEndPoints = new LinkedList<String>();

	public boolean resolveEndPoint(EndPointConfig endPointConfig) {
        this.serviceId = endPointConfig.getServiceId();
		this.fromEndPointParam = endPointConfig.getFrom().getFirst();
		this.toEndPointParam = endPointConfig.getTo();
		this.numOfEndPoints = endPointConfig.getTo().size();
		this.fromEndPoint = CreateServiceEndPoint(this.fromEndPointParam);
		this.toEndPoints = CreateToEndPoints(this.toEndPointParam);
		return true;

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
		endPointConfig.remove("ServiceEndPoint");
		endPointConfig.forEach((k, v) -> {

			fromEndPoint = k + "=" + v;

		});

		return fromEndPoint;
	}

	@Override
	public void configure() throws Exception {

		//from(fromEndPoint).to(toEndPoints.get(0)).to(toEndPoints.get(1)).to(toEndPoints.get(2)).routeId(serviceId)
		from(fromEndPoint).
		to(toEndPoints.get(0)).
		to(toEndPoints.get(1)).
		routeId(serviceId)
		;

	}

}
