package com.trupti.dao;

import java.util.Optional;

import com.trupti.entity.EmployeeEntity;

public interface EmployeeDAO {
	public Optional<EmployeeEntity> addEmployee(EmployeeEntity employeeEntity);
	public Optional<EmployeeEntity> getById(Integer empId);
}