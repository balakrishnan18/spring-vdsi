package com.demo.test;

public class Test implements Demo {

	@Override
	public void print(String message) {
		System.out.println("This is a demo impl");

	}

	public void fun() {
		System.out.println("Fun is here...");
	}

}
