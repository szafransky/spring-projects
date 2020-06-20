package com.szafranski.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping("/")
	public String showHome() {
		
		//need to create jsp view file in web-inf
		return "home";
	}
	
//	@GetMapping("/")
//	public String showLanding() {
//		
//		//need to create jsp view file in web-inf
//		return "landing";
//	}
	
	@GetMapping("/leaders")
	public String showLeaders() {
		
		//need to create jsp view file in web-inf
		return "leaders";
	}
	
	@GetMapping("/systems")
	public String showSystems() {
		
		//need to create jsp view file in web-inf
		return "systems";
	}
	
	

}
