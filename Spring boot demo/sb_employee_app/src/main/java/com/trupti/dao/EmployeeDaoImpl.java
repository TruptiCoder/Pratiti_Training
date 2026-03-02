package com.trupti.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trupti.entity.EmployeeEntity;
import com.trupti.repository.EmployeeRepository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private EmployeeRepository repository;

	@Override
	public boolean addEmployee(EmployeeEntity emp) {
		if (!repository.existsById(emp.getEmpId())) {
			repository.save(emp);
			return true;
		}
		return false;
	}

	@Override
	public EmployeeEntity getById(Integer id) {
		if (repository.existsById(id)) {
			EmployeeEntity emp = repository.findByEmpId(id);
			return emp;
		}
		return null;
	}

	@Override
	public List<EmployeeEntity> getByCity(String city) {
		List<EmployeeEntity> emps = repository.findByEmpCity(city);
		return emps;
	}

	@Override
	public List<EmployeeEntity> getByType(String type) {
		List<EmployeeEntity> emps = repository.findByType(type);
		return emps;
	}

	@Override
	public List<EmployeeEntity> getByCityAndType(String city, String type) {
		List<EmployeeEntity> emps = repository.findByEmpCityAndType(city, type);
		return emps;
	}

	@Override
	public List<EmployeeEntity> getAllEmployees() {
		return repository.findAll();
	}

	@Override
	public boolean updateEmployee(EmployeeEntity emp) {
		if (repository.existsById(emp.getEmpId())) {
			repository.save(emp);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteById(Integer id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
}
