package com.abdul.springprojects.zuul.filters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.abdul.springprojects.zuul.filters.pre.PreSimpleZuulFilter;

@Configuration
public class ZuulFilters {
	
	
	@Bean
	  public PreSimpleZuulFilter simplePreFilter() {
	    return new PreSimpleZuulFilter();
	  }

}
