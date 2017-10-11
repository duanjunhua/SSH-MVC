package com.djh.validate;

import com.opensymphony.xwork2.ActionSupport;

public class ValidationAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int age;
	private String email;
	private String password;
	private String confirmpwd;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpwd() {
		return confirmpwd;
	}
	public void setConfirmpwd(String confirmpwd) {
		this.confirmpwd = confirmpwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(age + ": " + email);
		return SUCCESS;
	}
}
