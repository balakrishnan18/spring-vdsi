package com.demo.spring.dao.impl;

import org.springframework.stereotype.Repository;

import com.demo.spring.Dao;
import com.demo.spring.Employee;

@Repository
public class JdbcDaoImpl implements Dao{

	@Override
	public String saveEmp(Employee e) {
		
		return "JDBC : Emp Saved";
	}

}
