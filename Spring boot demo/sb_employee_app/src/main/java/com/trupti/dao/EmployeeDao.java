package com.trupti.dao;

import java.util.List;

import com.trupti.entity.EmployeeEntity;

public interface EmployeeDao {

	boolean addEmployee(EmployeeEntity emp);

	EmployeeEntity getById(Integer id);

	List<EmployeeEntity> getByCity(String city);

	List<EmployeeEntity> getByType(String type);

	List<EmployeeEntity> getByCityAndType(String city, String type);

	List<EmployeeEntity> getAllEmployees();

	boolean updateEmployee(EmployeeEntity emp);

	boolean deleteById(Integer id);

}