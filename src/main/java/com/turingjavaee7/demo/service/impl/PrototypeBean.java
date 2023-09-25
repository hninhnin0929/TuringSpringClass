package com.turingjavaee7.demo.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Service;

import com.turingjavaee7.demo.service.PrototypeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeBean implements PrototypeService {

	public PrototypeBean() {
		log.info("Prototypebean created " + this);
	}

	@Override
	public void api() {
		log.info("API called");		
	}
	
}
