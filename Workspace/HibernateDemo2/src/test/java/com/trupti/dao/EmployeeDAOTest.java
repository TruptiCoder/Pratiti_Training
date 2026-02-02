package com.trupti.dao;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.trupti.entity.EmployeeEntity;
import com.trupti.entity.EmployeeInfo;

public class EmployeeDAOTest {
	
//	@Test
	public void testAddEmployee() {
		EmployeeDAO dao = new EmployeeDAOImp();
		EmployeeEntity employeeEntity = new EmployeeEntity("Shweta");
		EmployeeInfo employeeInfo = new EmployeeInfo();
		employeeInfo.setCity("Pune");
		employeeInfo.setEmail("shweta@mail.com");
		employeeEntity.setEmployeeInfo(employeeInfo);
		
//		Optional<EmployeeEntity> op = dao.addEmployee(new EmployeeEntity("Trupti"));
		Optional<EmployeeEntity> op = dao.addEmployee(employeeEntity);
		
		if(op.isPresent()) System.out.println(op.get());
		else System.out.println("Employee Add failed!");
	}
	
	@Test
	public void testGetById() {
		EmployeeDAO dao = new EmployeeDAOImp();
		Optional<EmployeeEntity> op = dao.getById(2);
		if(op.isPresent()) System.out.println(op.get());
		else System.out.println("Employee Not found!");
		
		Optional<EmployeeEntity> op1 = dao.getById(2);
		System.out.println(op1);
	}
	
}
