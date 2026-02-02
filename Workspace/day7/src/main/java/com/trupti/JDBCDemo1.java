package com.trupti;

import java.util.List;
import java.util.Optional;

import com.trupti.dao.EmployeeDAO;
import com.trupti.dao.EmployeeDAOImp;
import com.trupti.model.EmployeeEntity;

public class JDBCDemo1 {
	
	private static EmployeeDAO dao = new EmployeeDAOImp();

	public static void main(String[] args) {

//		Class.forName("com.mysql.cj.jdbc.Driver");

//		DriverManager.registerDriver(new Driver());
//		System.out.println("Driver loaded");

//		Connection con = GetConnection.getConnection();
//		System.out.println(con);
		
		addEmployee(new EmployeeEntity(4, null));
		getEmployeeById(2);
		getAllEmployees();
		
	}

	private static void getAllEmployees() {
		Optional<List<EmployeeEntity>> ee = dao.getAllEmployees();
		if(ee.isPresent()) {
			List<EmployeeEntity> list = ee.get();
			list.forEach(System.out::println);
		}
		else System.out.println("Not executed");
	}

	private static void getEmployeeById(int i) {
		Optional<EmployeeEntity> ee = dao.getEmployeeById(i);
		if(ee.isPresent()) System.out.println(ee);
		else System.out.println("Not executed");
	}

	private static void addEmployee(EmployeeEntity e) {
		Optional<EmployeeEntity> ee = dao.addEmployee(e);
		if(ee.isPresent()) System.out.println(ee);
		else System.out.println("Not executed");
	}

}
