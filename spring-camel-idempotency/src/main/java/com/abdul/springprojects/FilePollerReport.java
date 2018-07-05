package com.abdul.springprojects;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.commons.io.FileUtils;

public class FilePollerReport   {

	/*@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		
		Object numOfInFiles = exchange.getIn().getHeader("numOfInFiles");
		System.out.println("Number of files polled in :  "   + numOfInFiles.toString());
		
		Object file = exchange.getIn().getHeader("fileStore");
	//	System.out.println("Number of files polled in :  "   + file.toString());
		String content = FileUtils.readFileToString(new File(file.toString()));
		List<String> no = Arrays.asList(content.toString().split("\n"));
		System.out.println("Number of files already processed  :  "   + no.size());
		
	}*/
	
	private Logger logger = LogManager.getLogger(FilePollerReport.class);
	private String numOfNewFiles ;
	private String numOfProcessedFiles;
	
	public void setNewFiles(String numOfInFiles)   {
		// TODO Auto-generated method stub
		 
		numOfNewFiles  = numOfInFiles;
		
		 
		  
		
	}
	
	
	public void setOldFiles(String file) throws Exception {
		// TODO Auto-generated method stub
		
		//Object numOfInFiles = exchange.getIn().getHeader("numOfInFiles");
		//System.out.println("Number of files polled in :  "   + numOfInFiles.toString());
		
		//Object file = exchange.getIn().getHeader("fileStore");
	//	System.out.println("Number of files polled in :  "   + file.toString());
		String content = FileUtils.readFileToString(new File(file.toString()));
		List<String> no = Arrays.asList(content.toString().split("\n"));
		//System.out.println("Number of files already processed  :  "   + no.size());
		numOfProcessedFiles = String.valueOf(no.size());
		 
		
		numOfProcessedFiles = String.valueOf(no.size());
		 
	//	logger.info("numOfProcessedFiles: " + numOfProcessedFiles);
	//	logger.info("numOfNewFiles: " + numOfNewFiles);
		  
		
	}
	
	public void printReport() throws Exception {
		// TODO Auto-generated method stub
		
		//Object numOfInFiles = exchange.getIn().getHeader("numOfInFiles");
		//System.out.println("Number of files polled in :  "   + numOfInFiles.toString());
		
		//Object file = exchange.getIn().getHeader("fileStore");
	//	System.out.println("Number of files polled in :  "   + file.toString());
	////	String content = FileUtils.readFileToString(new File(file.toString()));
	//	List<String> no = Arrays.asList(content.toString().split("\n"));
		//System.out.println("Number of files already processed  :  "   + no.size());
	//	numOfProcessedFiles = String.valueOf(no.size());
	//	numOfNewFiles  = numOfInFiles;
		logger.info("numOfProcessedFiles1: " + this.numOfProcessedFiles);
		logger.info("numOfNewFiles1: " + this.numOfNewFiles);
		
		
	}
	
	

}
