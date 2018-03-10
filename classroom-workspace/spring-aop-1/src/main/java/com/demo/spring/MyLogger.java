package com.demo.spring;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLogger {

	@Before("execution(* com.demo.spring.EmpApp.registerEmp(..)) "
			+ "&& args(id,name,city,sal))")
	public void logBefore(int id, String name, String city, double sal) {
		System.out.println("Before method call..."+id+" "+name);
	}

	@AfterReturning(pointcut="execution(* "
			+ "com.demo.spring.EmpApp.registerEmp(..))",returning="retVal")
	public String logAfter(String retVal) {
		System.out.println("After method returns..."+retVal);
		return retVal;
	}
}
