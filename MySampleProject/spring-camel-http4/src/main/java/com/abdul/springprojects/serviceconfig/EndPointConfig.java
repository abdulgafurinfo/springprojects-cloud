package com.abdul.springprojects.serviceconfig;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EndPointConfig {
   
	public String serviceId;
	public LinkedList<LinkedHashMap<String, Object>> from = new LinkedList<LinkedHashMap<String, Object>>();
	public LinkedList<LinkedHashMap<String, Object>> to = new LinkedList<LinkedHashMap<String, Object>>();

	public LinkedList<LinkedHashMap<String, Object>> getFrom() {
		return from;
	}

	public void setFrom(LinkedList<LinkedHashMap<String, Object>> from) {
		this.from = from;
	}

	public LinkedList<LinkedHashMap<String, Object>> getTo() {
		return to;
	}

	public void setTo(LinkedList<LinkedHashMap<String, Object>> to) {
		this.to = to;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	@Override
	public String toString() {
		//System.out.println(to.get(1).get("TargetDirMaxFilesPerCycle"));
		return "EndPointConfig [from=" + from + ", to=" + to + "]";
	}

}
