package com.demo.spring;

import java.lang.reflect.Method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);

		Object app = ctx.getBean("app");
		
		System.out.println(app.getClass().getName());
		Method[] methods=app.getClass().getMethods();
		for(Method m:methods){
			System.out.println(m.getName());
		}
		
		EmpApp app1=(EmpApp)app;
		System.out.println(app1.registerEmp(100, "James", "Hyd", 45000));
		
		/*
		Dao dao=(Dao)ctx.getBean("jdbcDaoImpl");
		System.out.println(dao.saveEmp(new Employee(100, "James", "Hyd", 45000)));*/
	
	
	}

}
