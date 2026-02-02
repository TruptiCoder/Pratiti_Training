package com.trupti.dao;

import java.util.List;
import java.util.Optional;

import com.trupti.model.EmployeeEntity;

public interface EmployeeDAO {
	public Optional<EmployeeEntity> addEmployee(EmployeeEntity employeeEntity);
	public Optional<EmployeeEntity> getEmployeeById(Integer empId);
	public Optional<List<EmployeeEntity>> getAllEmployees();
	
}
