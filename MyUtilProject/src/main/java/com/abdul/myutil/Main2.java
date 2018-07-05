package com.abdul.myutil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {
	//private static String brokerUrlPattern =   "(?<component>[A-Za-z]+):" + "\\.+" + "?" + "(?<url>[A-Za-z=:]+)" + "\\.+"  ; "(?<url>[\\w]+)" "([\\w\\W]+)"
	//private static String brokerUrlPattern =   "(?<component>[A-Za-z]+)" + ":" + "(?<component1>[\\w\\:]+)\\?\\.*" + "host=" + "(?<host>[\\w]+)" + "([\\w\\W]+)" + "port=" + "(?<port>[\\d]+)"   ;
	private static String brokerUrlPattern =   "(?<component>[A-Za-z]+)" + ":" + "(?<destname>[\\w\\:]+)" +"\\?*" + "([\\w\\W]+)" +  "host=" + "(?<host>[\\w]+)" + "([\\w\\W]+)" + "port=" + "(?<port>[\\d]+)"   ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String brokerUrl = "amqp:topic:qname?brokerUrl=localhost:5672";
String brokerUrl = "amqp:topic:qname?host=localhost&port=5672&host=localhost&topic=test&port=5672&topic=test";
	//String brokerUrl = "amqp:topic:qname?host=localhost&port=5672";
	//	String brokerUrl = "amqp:topic:qname?";
    	Pattern pattern = Pattern.compile(brokerUrlPattern);
    	Matcher matcher = pattern.matcher(brokerUrl);
    	matcher.find();
    	
    	System.out.println("Component: " + matcher.group("component"));
    	System.out.println("Component1: " + matcher.group("component1"));
    	System.out.println("host: " + matcher.group("host"));
    	System.out.println("port: " + matcher.group("port"));
    	
    	//String p1 = "\\?*"+ "host=" + "([\\w]+)"  + "([\\W*]+)";
    //	String p2 =    "port=" + "([\\d]+)" +"([\\w*\\W*]+)";
    	String p1 = "host=" + "([\\w]+)"  + "([\\W*]+)";
    	String p2 =     "port=" + "([\\d]+)" +"\\W*";
    	String p3 =     "\\?$" ;
    	
    	String brokerUrl1 = brokerUrl.replaceAll(p1, "");
    	String brokerUrl2 = brokerUrl1.replaceAll(p2, "");
    	String brokerUrl3 = brokerUrl2.replaceAll(p3, "");
    	System.out.println(brokerUrl1);
    	System.out.println(brokerUrl2);
    	System.out.println(brokerUrl3);
	}

}
