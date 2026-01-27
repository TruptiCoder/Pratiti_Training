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

	public void updateId(int empId, int newEmpId) {
		Employee e = dao.getEmployeeById(empId);
		if(e != null) dao.updateEmployee(empId, newEmpId, e.getEmpName(), e.getEmpCity());
	}

	public void updateName(int empId, String newName) {
		Employee e = dao.getEmployeeById(empId);
		if(e != null) dao.updateEmployee(empId, e.getEmpId(), newName.toUpperCase(), e.getEmpCity());
	}

	public void updateCity(int empId, String newCity) {
		Employee e = dao.getEmployeeById(empId);
		if(e != null) dao.updateEmployee(empId, e.getEmpId(), e.getEmpName(), newCity);
	}

	public void updateNameAndCity(int empId, String newName, String newCity) {
		Employee e = dao.getEmployeeById(empId);
		if(e != null) dao.updateEmployee(empId, e.getEmpId(), newName.toUpperCase(), newCity);
	}

	public void deleteEmployee(int empId) {
		dao.deleteEmployee(empId);
	}
	
}
