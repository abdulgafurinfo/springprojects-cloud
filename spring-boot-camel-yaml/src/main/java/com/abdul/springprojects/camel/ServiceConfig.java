package com.abdul.springprojects.camel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Author Abdul Gafur D
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceConfig {

	
	private String serviceId;
	private String serviceName;
	@JsonIgnore
	private String sourcePath;
	 

	private String remoteEndPoint;
	private String remoteDir;
	private String remoteDirInterval;
	private String remoteDirMaxFilesPerCycle;

	private String targetType;
	private String targetURL;
	private String targetPort;
	private String targetDestination;

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getRemoteEndPoint() {
		return remoteEndPoint;
	}

	public void setRemoteEndPoint(String remoteEndPoint) {
		this.remoteEndPoint = remoteEndPoint;
	}

	public String getRemoteDir() {
		return remoteDir;
	}

	public void setRemoteDir(String remoteDir) {
		this.remoteDir = remoteDir;
	}

	public String getRemoteDirInterval() {
		return remoteDirInterval;
	}

	public void setRemoteDirInterval(String remoteDirInterval) {
		this.remoteDirInterval = remoteDirInterval;
	}

	public String getRemoteDirMaxFilesPerCycle() {
		return remoteDirMaxFilesPerCycle;
	}

	public void setRemoteDirMaxFilesPerCycle(String remoteDirMaxFilesPerCycle) {
		this.remoteDirMaxFilesPerCycle = remoteDirMaxFilesPerCycle;
	}

	public String getTargetType() {
		return targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}

	public String getTargetURL() {
		return targetURL;
	}

	public void setTargetURL(String targetURL) {
		this.targetURL = targetURL;
	}

	public String getTargetPort() {
		return targetPort;
	}

	public void setTargetPort(String targetPort) {
		this.targetPort = targetPort;
	}

	public String getTargetDestination() {
		return targetDestination;
	}

	public void setTargetDestination(String targetDestination) {
		this.targetDestination = targetDestination;
	}

	@Override
	public String toString() {
		return "ServiceConfig [serviceId=" + serviceId + ", serviceName=" + serviceName + ", remoteEndPoint="
				+ remoteEndPoint + ", remoteDir=" + remoteDir + ", remoteDirInterval=" + remoteDirInterval
				+ ", remoteDirMaxFilesPerCycle=" + remoteDirMaxFilesPerCycle + ", targetType=" + targetType
				+ ", targetURL=" + targetURL + ", targetPort=" + targetPort + ", targetDestination=" + targetDestination
				+ "]";
	}

	public String getSourcePath() {
		return sourcePath;
	}

	public void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
	}

}