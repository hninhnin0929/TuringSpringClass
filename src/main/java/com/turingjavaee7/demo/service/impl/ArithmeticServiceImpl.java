package com.turingjavaee7.demo.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.turingjavaee7.demo.service.ArithmeticService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Primary
public class ArithmeticServiceImpl implements ArithmeticService {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ArithmeticServiceImpl.class);
	
	ArithmeticServiceImpl(){
		log.info("Arithmetic Service Impl created");
	}
	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

}
