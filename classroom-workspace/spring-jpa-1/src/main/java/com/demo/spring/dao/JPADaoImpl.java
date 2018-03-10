package com.demo.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class JPADaoImpl implements Dao {

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public String save(Employee e) {
		em.persist(e);
		return "success";
	}

	@Override
	public String deleteEmp(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> listAllEmps() {
		Query query=em.createQuery("select e from Employee e");
		List<Employee> emps=query.getResultList();
		return emps;
	}

	@Override
	public Employee findEmpById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveList(List<Employee> emps) {
		// TODO Auto-generated method stub
		return null;
	}

}
