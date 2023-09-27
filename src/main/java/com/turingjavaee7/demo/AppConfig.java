package com.turingjavaee7.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.turingjavaee7.demo.model.ShoppingCart;
import com.turingjavaee7.demo.service.impl.ExampleBean;
import com.turingjavaee7.demo.service.impl.HelloMessageGenerator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class AppConfig {

	@Bean
	public ExampleBean exampleBean() 
	{
		log.info("Invoke via factory method");
		return new ExampleBean();
	}
	
	@Bean
	@RequestScope
	public HelloMessageGenerator requestScopedBean(){
		log.info("HelloMessageBean created ");
		return new HelloMessageGenerator();
	}
	
	@Bean
	@ApplicationScope
	public HelloMessageGenerator appScopedBean(){
		log.info("ApplicationScope Bean created ");
		return new HelloMessageGenerator();
	}
	
	@Bean
	@SessionScope
	public ShoppingCart shoppingCart() {
		log.info("ShoppingCart created");
		return new ShoppingCart();
	}
	
}
