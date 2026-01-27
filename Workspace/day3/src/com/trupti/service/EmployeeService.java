package com.trupti.service;

import com.trupti.dao.EmployeeDAO;
import com.trupti.model.Employee;

public class EmployeeService {
	
	private EmployeeDAO dao = new EmployeeDAO();
	
	public EmployeeService() {
		
	}
	
	public void addEmployeeService(Employee... employees) {		
		for(Employee e : employees) {
			if(e != null) e.setEmpName(e.getEmpName().toUpperCase());
		}
		dao.addEmployee(employees);
	}

	public Employee[] getEmployees() {
		return dao.getEmployees();
	}

	public boolean verifyId(int empId) {
		return dao.getId(empId);
	}
}
