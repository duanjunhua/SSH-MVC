package com.djh.michael.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.djh.michael.bean.Employee;

public class EmployeeDAO {

	private static Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
	static{
		employees.put(4001, new Employee(4001, "Tom", "Li", "tom.li.demo@struts.com"));
		employees.put(4002, new Employee(4002, "Lucy", "Qin", "lucy.qin.demo@struts.com"));
		employees.put(4005, new Employee(4005, "Michael", "Duan", "michael.duan.demo@struts.com"));
		employees.put(4003, new Employee(4003, "Jhon", "Xiao", "jhon.xiao.demo@struts.com"));
		employees.put(4004, new Employee(4004, "James", "Chen", "james.chen.demo@struts.com"));
	}
	
	public List<Employee> getEmployees(){
		return new ArrayList<>(employees.values());
	}
	
	public void deletEmployee(Integer employeeId){
		employees.remove(employeeId);
	}
	
	public void add(Employee employee){
		long time = System.currentTimeMillis();
		employee.setEmployeeId((int)time);
		employees.put(employee.getEmployeeId(), employee);
	}
	
	public Employee getEmployee(Integer employeeId){
		return employees.get(employeeId);
	}
	public void update(Employee employee){
		employees.put(employee.getEmployeeId(), employee);
	}
}
