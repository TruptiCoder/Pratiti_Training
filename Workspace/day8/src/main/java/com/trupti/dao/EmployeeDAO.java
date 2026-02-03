package com.trupti.dao;

import java.util.List;
import java.util.Optional;

import com.trupti.entity.EmployeeEntity;

public interface EmployeeDAO {

	Optional<EmployeeEntity> addEmployee(EmployeeEntity employeeEntity);
	public Optional<EmployeeEntity> getEmployeeById(Integer id);
	public Optional<List<EmployeeEntity>> getAllEmployees();
}