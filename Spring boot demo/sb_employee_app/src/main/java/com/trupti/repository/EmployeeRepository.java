package com.trupti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trupti.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
	EmployeeEntity findByEmpId(Integer empId);
	List<EmployeeEntity> findByEmpCity(String empCity);
	List<EmployeeEntity> findByType(String type);
	List<EmployeeEntity> findByEmpCityAndType(String city, String type);
}
