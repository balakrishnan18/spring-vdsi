package com.demo.spring;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.spring.model.Emp;

@FeignClient("emp-service")
public interface EmpService {
	@RequestMapping(path="/find", method=RequestMethod.GET,produces="application/json")
	//http://host:port/find?empid=101
	public String getEmpById(@RequestParam("empid")int id);
	
	@RequestMapping(path = "/save", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String saveEmp(@RequestBody Emp e);
}
