package com.demo.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping(path = "/demo")
	public String getWelcomePage() {
		return "welcome";
	}
	
	@RequestMapping(path = "/test")
	public String fun() {
		return "welcome2";
	}
}
