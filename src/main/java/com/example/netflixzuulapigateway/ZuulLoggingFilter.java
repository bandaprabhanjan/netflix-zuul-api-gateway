package com.example.netflixzuulapigateway;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class ZuulLoggingFilter extends ZuulFilter {
	private Logger logger= LoggerFactory.getLogger(this.getClass());

/*
 *shouldFilter checks based on  business logic this filter should executes or not
 *true means execute this filter for every request
 */
	
	@Override
	public boolean shouldFilter() {
		return true;
	}
//details of the current request
	@Override
	public Object run() {
		HttpServletRequest request = 
				RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {} request uri -> {}",
						request, request.getRequestURI());
		
		return null;
	}
/*
 * when should the filtering to be happen like before the request executed or after the request has executed"pre"/"post"/"error"
 */
	@Override
	public String filterType() {
		return "pre";
	}

	/* if we have multiple filters like ZuulFilter or Zuul security filter we can prioritize them by using filter order/*
	 */
	@Override
	public int filterOrder() {
		return 1;
	}

}
