package com.turingjavaee7.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.turingjavaee7.demo.service.ArithmeticService;
import com.turingjavaee7.demo.service.PrototypeService;
import com.turingjavaee7.demo.service.impl.HelloMessageGenerator;
import com.turingjavaee7.demo.service.impl.PrototypeBean;
import com.turingjavaee7.demo.service.impl.PrototypeDemo;

import jakarta.annotation.Resource;
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
	
	@Resource(name = "requestScopedBean")
	HelloMessageGenerator requestScopedBean;
	
	public HomeController() {
		log.info("Home Controller created ");
	}
	
	@Autowired
	PrototypeService prototypeService;
	
	@GetMapping("/")
	String home() {
		
		try {
			log.info("Handleby thread " + Thread.currentThread().getName());
			Thread.sleep(2000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
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
	
	@GetMapping("/scopes/request")
	public String getRequestScopeMessage(final Model model) {
		
		log.info("HelloMessage Generator", this);
		model.addAttribute("previousMessage", requestScopedBean.getMessage());
		requestScopedBean.setMessage("Good morning!");
		model.addAttribute("currentMessage", requestScopedBean.getMessage());
		
		return "scopesExample";
	}
	
	@Resource(name = "appScopedBean")
	HelloMessageGenerator appScopedBean;
	
	@GetMapping("/scopes/application")
	public String getApplicationScopeMessage(final Model model) {
		
		log.info("HelloMessage Generator: appScopedBean", this);
		model.addAttribute("previousMessage", appScopedBean.getMessage());
		requestScopedBean.setMessage("Good afternoon!");
		model.addAttribute("currentMessage", appScopedBean.getMessage());
		
		return "appScopedBean";
	}
}
