package com.demo.spring.dao.impl;

import org.springframework.stereotype.Repository;

import com.demo.spring.Dao;
import com.demo.spring.Employee;


public class HibDaoImpl implements Dao{

	@Override
	public String saveEmp(Employee e) {
		
		return "Hibernate : Emp Saved";
	}

}
