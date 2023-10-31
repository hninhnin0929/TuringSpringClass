package com.turingjavaee7.demo.interceptor;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Enumeration;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.turingjavaee7.demo.service.AuthenticationException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("LogInterceptor::preHandle()" + request.getRequestURI());
        
        String url = request.getServletPath();
        log.info("Servlet path " + url);
        if(url.equals("http://localhost:8080/admin")) 
        {
        	log.info("Admin end point");
        	//WARNING do not use GET method in realworld app
        	String userName = request.getParameter("username");
        	String password = request.getParameter("password");
        	if("admin".equals(userName) && "admin".equals(password)) 
        	{
        		return true;
        	}
        	else
        	{
        		response.setStatus(403);
        		throw new AuthenticationException("Invalid user");
//        		return false;      		
        	}
        }
        else 
        {
        	Enumeration<String> headers = request.getHeaderNames();
        	while(headers.hasMoreElements()) 
        	{
        		String name = headers.nextElement();
        		String value = request.getHeader(name);
        		log.info("Header  " + name + "=>" + value);
        	}
        	
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("LogInterceptor::postHandle()" + request.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("LogInterceptor::afterCompletion()" + request.getRequestURI());
    }
}
