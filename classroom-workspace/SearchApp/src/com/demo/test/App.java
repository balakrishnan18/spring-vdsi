package com.demo.test;

public class App {
	

	public static void main(String[] args) {
		
		Demo d= new Test();
		d.print("Hi");
		
		
		
		Demo d1=new Demo(){

			@Override
			public void print(String message) {
				System.out.println(message);
				
			}};
			
			d1.print("Hello");
			
		Demo d2=(message)->System.out.println(message);
			
			d2.print("test MEssage");
			
		
	}
}
