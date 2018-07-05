package com.abdul.springprojects;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

import org.apache.camel.processor.idempotent.FileIdempotentRepository;
 
@Configuration
public class BeanConfig {
	
//	private String fileRepo = "FileRepository";
	private File fileStore = new File("FileRepository/file-idempotent-store-2");
	private int cacheSize = 2000;
	
	@Bean
	public FileIdempotentRepository fileIdempotentRepository() {
		
		return (FileIdempotentRepository) FileIdempotentRepository.fileIdempotentRepository(fileStore, cacheSize);
		
	}

}
