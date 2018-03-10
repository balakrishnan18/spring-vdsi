package com.demo.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring.dao.Dao;
import com.demo.spring.dao.Employee;

@Service
public class EmpApp {
	@Autowired
	Dao dao;

	public String registerEmp(int id, String name, String city, double sal) {
		String response = dao.save(new Employee(id, name, city, sal));
		if (response.equals("success"))
			return "Employee Registered";

		return "Employee Could Not be Registered";
	}

	public void showAllEmps() {
		List<Employee> list = dao.listAllEmps();
		for (Employee e : list) {
			System.out.println(e.getEmpId() + " " + e.getName() + " " + e.getSalary());
		}
	}

	public String findEmp(int id) {
		Employee e = dao.findEmpById(id);
		if (e != null) {
			return e.getEmpId() + " " + e.getName() + " " + e.getSalary();
		} else {
			return "No data";
		}
	}

	public String saveEmpList(List<Employee> emps) {
		String s = dao.saveList(emps);
		return s;
	}
}
