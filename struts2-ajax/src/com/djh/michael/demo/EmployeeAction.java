package com.djh.michael.demo;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.djh.michael.bean.Employee;
import com.djh.michael.dao.EmployeeDAO;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class EmployeeAction implements RequestAware, ModelDriven<Employee>, Preparable{
	
	EmployeeDAO employeeDAO = new EmployeeDAO();
	private Map<String, Object> request;
	private Integer employeeId;
//	
	public void setEmployeeId(Integer employeeId){
		this.employeeId = employeeId;
	}
	private Employee employee;
	
	public String save(){
		employeeDAO.add(employee);
		return "success";
	}
	
	public String update(){
		employeeDAO.update(employee);
		return "success";
	}
	
	public void prepareUpdate(){
		employee = employeeDAO.getEmployee(employeeId);
	}
	
	public String edit(){
//		Employee emp = employeeDAO.getEmployee(employee.getEmployeeId());
//		employee.setFirstName(emp.getFirstName());
//		employee.setLastName(emp.getLastName());
//		employee.setEmail(emp.getEmail());
//		employeeDAO.update(employee);
		return "edit";
	}
	
	public void prepareEdit(){
		employee = employeeDAO.getEmployee(employeeId);
	}
	
	
	public String delete(){
		employeeDAO.deletEmployee(employee.getEmployeeId());
		return "success";
	}
	
	public String list(){
		request.put("employees", employeeDAO.getEmployees());
		return "list";
	}


	@Override
	public void setRequest(Map<String, Object> map) {
		// TODO Auto-generated method stub
		this.request = map;
	}

	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
//		employee = new Employee();			//继承Preparable后在需要的地方定义
		if(employeeId == null){
			employee = new Employee();
		}else{
			employee = employeeDAO.getEmployee(employeeId);
		}
		return employee;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("prepared...");
	}
}
