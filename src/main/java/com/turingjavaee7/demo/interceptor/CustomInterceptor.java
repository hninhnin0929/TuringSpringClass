package com.turingjavaee7.demo.interceptor;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomInterceptor implements WebRequestInterceptor {

	@Override
	public void preHandle(WebRequest request) throws Exception {
		log.info("Prehandle " + request.getContextPath());		
	}

	@Override
	public void postHandle(WebRequest request, ModelMap model) throws Exception {
		log.info("Posthandle " + request.getContextPath());		
	}

	@Override
	public void afterCompletion(WebRequest request, Exception ex) throws Exception {
		log.info("afterCompletion " + request.getContextPath());		
	}

}
