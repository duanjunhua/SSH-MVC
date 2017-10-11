package com.djh;

import java.sql.Date;

public class Employee {

	private int id;
	private int employeeId;
	private String employeeName;
	private double employeeSalary;
	private Date birthday;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Employee(int employeeId, String employeeName, double employeeSalary, Date birthday) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.birthday = birthday;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}
}
