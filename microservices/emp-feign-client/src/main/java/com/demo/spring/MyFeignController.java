package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.model.Emp;

@RestController
public class MyFeignController {

	@Autowired
	EmpService feignClient;

	@RequestMapping(path = "/feign-get/{id}")
	public String getEmp(@PathVariable("id") int id) {
		return feignClient.getEmpById(id);
	}
	@RequestMapping(path = "/save")
	//http://localhost:port/save?id=108&name=Navin&city=nowhere&salary=34000
	public String saveData(
			@RequestParam("id")int id, 
			@RequestParam("name")String name,
			@RequestParam("city")String city,
			@RequestParam("salary")double sal){
		
		Emp e= new Emp(id,name,city,sal);
		String resp=feignClient.saveEmp(e);
		return resp;
	}
}
