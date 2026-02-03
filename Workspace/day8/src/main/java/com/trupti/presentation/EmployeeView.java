package com.trupti.presentation;

import java.util.List;
import java.util.Optional;

import com.trupti.model.EmployeeDTO;
import com.trupti.service.EmployeeService;
import com.trupti.service.EmployeeServiceImpl;

public class EmployeeView {
	
	private EmployeeService employeeService = new EmployeeServiceImpl();
	
	public EmployeeView() {
//		addEmployee();
		getAllEmployees();
	}

	private void addEmployee() {
		EmployeeDTO employee = new EmployeeDTO(2, "Trupti", "Balbudhe", "Pune");
		employeeService.addEmployee(employee);
	}
	
	private void getAllEmployees() {
		List<EmployeeDTO> employees = employeeService.getAllEmployees().get();
		employees.forEach(System.out::println);
	}
	
}
