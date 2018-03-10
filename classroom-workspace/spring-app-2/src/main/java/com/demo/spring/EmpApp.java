package com.demo.spring;

public class EmpApp {
	Dao dao;

	
	public void setDao(Dao dao) {
		this.dao = dao;
	}

public String registerEmp(int id, String name, String city, double sal) {
		String retVal=dao.saveEmp(new Employee(id, name, city, sal));
		System.out.println(retVal);
		return "Emplyee Registered";
	}
}
