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
<<<<<<< HEAD
	 // changes made
=======
	 
>>>>>>> 0547cf1d3a647b76ff0949840aa7793dbc6fc09b
}
