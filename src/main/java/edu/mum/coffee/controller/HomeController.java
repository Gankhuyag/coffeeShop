package edu.mum.coffee.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.mum.coffee.service.OrderService;
 
@Controller
public class HomeController {
	
 
	
	@GetMapping({"/", "/index", "/home"})
	public String homePage() {
		return "home";
	}

	@GetMapping({"/secure"})
	public String securePage() {
		return "secure";
	}
	 
}
