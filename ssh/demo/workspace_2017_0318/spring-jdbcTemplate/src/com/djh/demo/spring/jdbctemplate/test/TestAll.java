package com.djh.demo.spring.jdbctemplate.test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.djh.demo.spring.jdbctemplate.beans.Employee;
import com.djh.demo.spring.jdbctemplate.beans.EmployeeDAO;

public class TestAll {

	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	{
		ctx = new ClassPathXmlApplicationContext("springJdbcContext.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		namedParameterJdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);
	}
	
	@Test
	public void testNamedParameterJdbcTemplateSQLSource(){
		String namedParameterSQL = "insert into employees values(null, :lastName, :email)";
		Employee employee = new Employee();
		employee.setLastName("Bob");
		employee.setEmail("Bob@outlook.com");
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(employee);
		namedParameterJdbcTemplate.update(namedParameterSQL, paramSource);
	}
	
	/**
	 * 便于维护
	 */
	@Test
	public void testNamedParameterJdbcTemplate(){
		String namedParameterSQL = "insert into employees values(null, :lastName, :email)";
		Map<String, Object> param = new HashMap<>();
		param.put("lastName", "Anna");
		param.put("email", "Anna@outlook.com");
		namedParameterJdbcTemplate.update(namedParameterSQL, param);
	}
	
	@Test
	public void testEmployeeDao(){
		EmployeeDAO employeeDAO = (EmployeeDAO) ctx.getBean("employeeDAO");
		Employee employee = employeeDAO.getEmployeeById(2);
		System.out.println(employee);
	}
	
	@Test
	public void testQueryList(){
		//查询实体类的集合
		String queryListSQL = "select id, last_name lastName, email from employees where id > ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		List<Employee> employees = jdbcTemplate.query(queryListSQL, rowMapper, 4);
		for (Employee employee : employees) {
			System.out.println(employee.toString());
		}
	}
	@Test
	public void testQueryObject(){
		//查询一条信息
		String queryObjectSQL = "select id, last_name lastName, email from employees where id = ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(queryObjectSQL, rowMapper, 4);
		System.out.println(employee.toString());
	}
	
	@Test
	public void testInsertListObjects(){
		//JdbcTempalte批量插入
		String batchSql = "insert into employees values(null, ?, ?)";
		List<Object[]> batchArgs = new ArrayList<>();
		batchArgs.add(new Object[]{"David","David@outlook.com"});
		batchArgs.add(new Object[]{"Alex","Alex@outlook.com"});
		batchArgs.add(new Object[]{"Willian","Willian@outlook.com"});
		jdbcTemplate.batchUpdate(batchSql, batchArgs);
	}
	
	@Test
	public void testInsertObject(){
		//JdbcTemplate update or insert one record
		String sql = "insert into employees values(null, ?, ?)";
		jdbcTemplate.update(sql, "Kay", "Kay@outlook.com");
	}
	@Test
	public void testJDBC() throws Exception{
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource.getConnection());
		System.out.println(jdbcTemplate);
	}
	
}
