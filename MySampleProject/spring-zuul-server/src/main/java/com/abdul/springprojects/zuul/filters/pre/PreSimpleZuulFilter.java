package com.abdul.springprojects.zuul.filters.pre;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class PreSimpleZuulFilter extends ZuulFilter {
	
	private static Logger logger = LoggerFactory.getLogger(PreSimpleZuulFilter.class);

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		logger.info("Should filter");
		return false;
	}

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		
		RequestContext ctx = RequestContext.getCurrentContext();
	    HttpServletRequest request = ctx.getRequest();
	    logger.info("into run");
	    logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
	  //  logger.info(String.format("%s request to %s", request., request.getRequestURL().toString()));
	    
	    return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		logger.info("Pre filter");
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		logger.info("filter oder");
		return 1;
	}
	
	
	 
	
	

}
