package com.trupti.service;

import java.util.List;

import com.trupti.model.EmployeeModel;

public interface EmployeeService {

	List<Integer> addEmployees(EmployeeModel... employeeModels);

	boolean updateEmployee(EmployeeModel emp);

	boolean deleteById(Integer id);

	List<EmployeeModel> getAllEmployees();

	List<EmployeeModel> getByCity(String city);

	List<EmployeeModel> getByCityAndType(String city, String type);

	List<EmployeeModel> getByType(String type);

	EmployeeModel getById(Integer id);

}