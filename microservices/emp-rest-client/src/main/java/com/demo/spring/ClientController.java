package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

	@Autowired
	RestTemplate rt;

	@RequestMapping(path = "/get/{id}")
	//http://localhost:9090/get/102
	public String getEmpData(@PathVariable("id") int id) {
	String response = 
			rt.getForObject("http://emp-service/find?empid=" + id, String.class);
		return response;
	}
}
