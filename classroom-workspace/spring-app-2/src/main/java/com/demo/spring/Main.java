package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");

		EmpApp app = (EmpApp) ctx.getBean("app");
		System.out.println(app.registerEmp(100, "James", "Hyd", 45000));
	}

}
