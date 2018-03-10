package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);

		EmpApp app = (EmpApp) ctx.getBean("app");
		System.out.println(app.registerEmp(100, "James", "Hyd", 45000));
		
		Dao dao=(Dao)ctx.getBean("jdbcDaoImpl");
		System.out.println(dao.saveEmp(new Employee(100, "James", "Hyd", 45000)));
	
	
	}

}
