package com.abdul.springprojects;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FileUtils;

public class FilePollerReport  implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		
		Object numOfInFiles = exchange.getIn().getHeader("numOfInFiles");
		System.out.println("Number of files polled in :  "   + numOfInFiles.toString());
		
		Object file = exchange.getIn().getHeader("fileStore");
	//	System.out.println("Number of files polled in :  "   + file.toString());
		String content = FileUtils.readFileToString(new File(file.toString()));
		List<String> no = Arrays.asList(content.toString().split("\n"));
		System.out.println("Number of files already processed  :  "   + no.size());
		
	}
	
	

}
