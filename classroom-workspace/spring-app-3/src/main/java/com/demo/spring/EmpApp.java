package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("app")
public class EmpApp {
	
	@Autowired
	@Qualifier("hibDao")
	Dao dao;
	
	@Autowired
	@Qualifier("jdbcDaoImpl")
	Dao dao1;

public String registerEmp(int id, String name, String city, double sal) {
		String retVal=dao.saveEmp(new Employee(id, name, city, sal));
		System.out.println(retVal);
		return "Emplyee Registered";
	}
}
