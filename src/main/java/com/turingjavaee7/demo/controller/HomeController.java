package com.turingjavaee7.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.turingjavaee7.demo.service.ArithmeticService;

import lombok.extern.slf4j.Slf4j;



@Controller
@Slf4j
public class HomeController {
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	ArithmeticService arithmeticService;
	
	public HomeController() {
		log.info("Home Controller created");
	}
	
	@GetMapping("/")
	String home() {
		log.info("Get / "+ arithmeticService.add(1, 2));
		return "home";
	}
	
}
