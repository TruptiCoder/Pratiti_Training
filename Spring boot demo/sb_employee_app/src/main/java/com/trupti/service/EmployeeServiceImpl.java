package com.trupti.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trupti.dao.EmployeeDao;
import com.trupti.entity.EmployeeEntity;
import com.trupti.model.EmployeeModel;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Integer> addEmployees(EmployeeModel... employeeModels) {
		List<Integer> failed = new ArrayList<>();
		List<EmployeeEntity> emps = Arrays.stream(employeeModels).map(model -> mapper.map(model, EmployeeEntity.class))
				.toList();
		emps.forEach(emp -> {
			boolean res = dao.addEmployee(emp);
			if (!res)
				failed.add(emp.getEmpId());
		});
		return failed;
	}

	@Override
	public boolean updateEmployee(EmployeeModel emp) {
		EmployeeEntity empEntity = mapper.map(emp, EmployeeEntity.class);
		boolean res = dao.updateEmployee(empEntity);
		return res;
	}

	@Override
	public boolean deleteById(Integer id) {
		boolean res = dao.deleteById(id);
		return res;
	}

	@Override
	public List<EmployeeModel> getAllEmployees() {
		List<EmployeeEntity> emps = dao.getAllEmployees();
		if (emps.size() == 0)
			return null;
		List<EmployeeModel> empModels = new ArrayList<>();
		emps.forEach(emp -> {
			empModels.add(mapper.map(emp, EmployeeModel.class));
		});
		return empModels;
	}

	@Override
	public List<EmployeeModel> getByCity(String city) {
		List<EmployeeEntity> emps = dao.getByCity(city);
		if (emps.size() == 0)
			return null;
		List<EmployeeModel> empModels = new ArrayList<>();
		emps.forEach(emp -> {
			empModels.add(mapper.map(emp, EmployeeModel.class));
		});
		return empModels;
	}

	@Override
	public List<EmployeeModel> getByCityAndType(String city, String type) {
		List<EmployeeEntity> emps = dao.getByCityAndType(city, type);
		if (emps.size() == 0)
			return null;
		List<EmployeeModel> empModels = new ArrayList<>();
		emps.forEach(emp -> {
			empModels.add(mapper.map(emp, EmployeeModel.class));
		});
		return empModels;
	}

	@Override
	public List<EmployeeModel> getByType(String type) {
		List<EmployeeEntity> emps = dao.getByType(type);
		if (emps.size() == 0)
			return null;
		List<EmployeeModel> empModels = new ArrayList<>();
		emps.forEach(emp -> {
			empModels.add(mapper.map(emp, EmployeeModel.class));
		});
		return empModels;
	}

	@Override
	public EmployeeModel getById(Integer id) {
		EmployeeEntity emp = dao.getById(id);
		if (emp == null)
			return null;
		EmployeeModel empModel = mapper.map(emp, EmployeeModel.class);
		return empModel;
	}
}
