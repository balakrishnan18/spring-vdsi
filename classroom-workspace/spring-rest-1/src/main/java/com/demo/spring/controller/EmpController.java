package com.demo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.dao.Dao;
import com.demo.spring.dao.Employee;

@RestController
public class EmpController {

	@Autowired
	Dao dao;

	@RequestMapping(path = "/emp", method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public Employee getEmployee() {
		Employee e = dao.findEmpById(100);
		return e;
	}

	@RequestMapping(path = "/emp", method = RequestMethod.POST, produces = { MediaType.TEXT_PLAIN_VALUE },
			consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity saveEmp(
			@RequestParam("id")int id, 
			@RequestParam("name")String name, 
			@RequestParam("city")String city, 
			@RequestParam("salary")double sal) {

		dao.save(new Employee(id, name, city, sal));
		return ResponseEntity.ok("Data Saved");
	}
	
	@RequestMapping(path = "/empjson", method = RequestMethod.POST, produces = { MediaType.TEXT_PLAIN_VALUE },
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public String saveEmp1(@RequestBody Employee e	) {

		dao.save(e);
		return "success";
	}
}
