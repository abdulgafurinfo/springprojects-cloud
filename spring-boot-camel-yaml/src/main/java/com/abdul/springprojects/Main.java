package com.abdul.springprojects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import com.abdul.springprojects.camel.EndPointConfig;

public class Main {
	
	static EndPointConfig config = null;
	static DumperOptions options = new DumperOptions();
	 static Yaml yaml = new Yaml(options);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		 
	    options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
	    options.setPrettyFlow(true);
	    
	  
	    
		readYaml(args[0]);
	 
		createYaml(config);
		 
	}

	private static void createYaml(EndPointConfig config) {
		// TODO Auto-generated method stub
		LinkedList<LinkedHashMap<String, Object>> from = new LinkedList<LinkedHashMap<String, Object>>();
		LinkedList<LinkedHashMap<String, Object>> to = new LinkedList<LinkedHashMap<String, Object>>();
		
	    LinkedHashMap<String, Object> tempMap = new LinkedHashMap<>();
	    tempMap.put("RemoteEndPoint", "file");
	    tempMap.put("remoteDir", "/sample/dev");
	    tempMap.put("remoteDirInterval", 500);
	    tempMap.put("remoteDirMaxFilesPerCycle", 30);
	    
	    from.add(tempMap);
	    
	    LinkedHashMap<String, Object> map1 = new LinkedHashMap<>();
	    map1.put("TargetEndPoint", "activemq:topic");
	    map1.put("TargetUrl", "localhost");
	    map1.put("TargetProtocol", "amqp");
	    map1.put("TargetPort", 8080);
	    LinkedHashMap<String, Object> map2 = new LinkedHashMap<>();
	    map2.put("TargetEndPoint", "rabbitmq:topic");
	    map2.put("TargetUrl", "localhost");
	    map2.put("TargetProtocol", "amqp");
	    map2.put("TargetPort", "8081");
	    
	    to.add(map1); to.add(map2);
	    
	    String output = yaml.dump(to);
	    try {
			yaml.dump(to,new FileWriter("out.yml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("Created as:");
	      System.out.println(output);
	   
	    
		
	}

	private static void readYaml(String string) {
		// TODO Auto-generated method stub
		try {
			config = yaml.loadAs(new FileInputStream(new File(string)), EndPointConfig.class);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Reading as:");
		System.out.println(config);
	}

}
