package com.demo.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.dao.Employee;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		EmpApp app = (EmpApp) ctx.getBean("empApp");
		// String resp = app.registerEmp(200, "James", "Hyderabad", 89000);
		// System.out.println(resp);

		// app.showAllEmps();
		// System.out.println(app.findEmp(100));
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(115, "Karan", "Mumbai", 55000));
		empList.add(new Employee(116, "Amit", "Delhi", 45000));
		empList.add(new Employee(107, "Arun", "Bangalore", 45000));
		empList.add(new Employee(118, "Kiran", "London", 65000));

		app.saveEmpList(empList);

	}

}
