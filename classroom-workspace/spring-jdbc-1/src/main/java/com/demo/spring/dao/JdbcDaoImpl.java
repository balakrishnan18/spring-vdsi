package com.demo.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class JdbcDaoImpl implements Dao {

	@Autowired
	JdbcTemplate jt;

	@Override
	public String save(Employee e) {
		int row = jt.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement("insert into emp values(?,?,?,?)");
				pst.setInt(1, e.getEmpId());
				pst.setString(2, e.getName());
				pst.setString(3, e.getCity());
				pst.setDouble(4, 56000);
				return pst;
			}
		});
		if (row == 1)
			return "success";
		return "failure";
	}

	@Override
	public String deleteEmp(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> listAllEmps() {
		List<Employee> empList = jt.query("select * from emp", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee e = new Employee(rs.getInt("EMPNO"), rs.getString("NAME"), rs.getString("ADDRESS"),
						rs.getDouble("SALARY"));
				return e;
			}

		});
		return empList;
	}

	@Override
	public Employee findEmpById(int id) {
		Employee e1 = null;
		try {
			e1 = jt.queryForObject("select * from emp where empno=" + id, new RowMapper<Employee>() {

				@Override
				public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
					Employee e = new Employee(rs.getInt("EMPNO"), rs.getString("NAME"), rs.getString("ADDRESS"),
							rs.getDouble("SALARY"));
					return e;
				}

			});
		} catch (Exception e) {
			System.out.println("No Employee with given ID");
			e1 = null;
		}
		return e1;
	}

	@Override
	@Transactional
	public String saveList(List<Employee> emps) {

		for (Employee e : emps) {
			save(e);
		}

		return "success";
	}

}
