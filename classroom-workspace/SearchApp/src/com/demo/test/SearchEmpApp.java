package com.demo.test;

import java.util.HashSet;
import java.util.Set;

import com.demo.test.model.Employee;

public class SearchEmpApp {

	public static void main(String[] args) {

		Set<Employee> empSet = new HashSet<>();
		//List<Employee> empSet=new ArrayList<>();

		empSet.add(new Employee(100, "James", "London", 25000));
		empSet.add(new Employee(102, "Scott", "London", 35000));
		empSet.add(new Employee(103, "Kitty", "New York", 55000));
		empSet.add(new Employee(104, "Krishna", "Bangalore", 65000));
		empSet.add(new Employee(105, "Karan", "Mumbai", 55000));
		empSet.add(new Employee(106, "Amit", "Delhi", 45000));
		empSet.add(new Employee(107, "Arun", "Bangalore", 45000));
		empSet.add(new Employee(108, "Kiran", "London", 65000));

		for (Employee e : empSet) {
			if (e.getSalary() > 40000) {
				System.out.println(e.getEmpId() + " " +
			e.getName() + " " + e.getCity() + " " + e.getSalary());
			}
		}

	}

}
