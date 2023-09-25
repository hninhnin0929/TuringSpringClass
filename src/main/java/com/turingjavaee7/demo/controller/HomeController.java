package com.turingjavaee7.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.turingjavaee7.demo.service.ArithmeticService;
import com.turingjavaee7.demo.service.PrototypeService;
import com.turingjavaee7.demo.service.impl.PrototypeBean;
import com.turingjavaee7.demo.service.impl.PrototypeDemo;

import lombok.extern.slf4j.Slf4j;



@Controller
@Slf4j
public class HomeController {

	int a;
	
	@Autowired
	@Qualifier("arithTwo")
	ArithmeticService arithmeticService;
	
//	public void setArithmeticService(ArithmeticService arithService) {
//		log.info("Setter injected for Arithmetic Service");
//		this.arithmeticService = arithService;
//	}
	
	public HomeController() {
		log.info("Home Controller created ");
	}
	
	@Autowired
	PrototypeService prototypeService;
	
	@GetMapping("/")
	String home() {
		
		PrototypeService service = new PrototypeDemo().getPrototype();
		log.info("Service " + service);
		log.info("Home controller / " + this.a);
		log.info("Get / "+ arithmeticService.add(1, 2));
		log.info("Service " + arithmeticService);
		a++;
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			
		}
		return "home";
	}
	
}
