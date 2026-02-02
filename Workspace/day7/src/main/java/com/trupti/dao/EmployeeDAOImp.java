package com.trupti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.trupti.model.EmployeeEntity;
import com.trupti.util.GetConnection;

public class EmployeeDAOImp implements EmployeeDAO {
	
	private Connection connection = GetConnection.getConnection();

	@Override
	public Optional<EmployeeEntity> addEmployee(EmployeeEntity employeeEntity) {
		Integer empId = employeeEntity.getEmpId();
		String empName = employeeEntity.getEmpName();
		
//		String sql = "insert into employee values (" + empId + ",'" + empName + "');";
		
		String sqlP = "insert into employee values(?, ?);";
		
		try {
//			Statement statement = connection.createStatement();
//			int r = statement.executeUpdate(sql);
			
			PreparedStatement ps = connection.prepareStatement(sqlP);
			ps.setInt(1, empId);
			ps.setString(2, empName);
			
			int r = ps.executeUpdate();
			if(r != 0) return Optional.of(employeeEntity);
			else return Optional.ofNullable(employeeEntity);
			
		} catch (SQLException e) {
//			e.printStackTrace();
			return Optional.empty();
		}
		
	}

	@Override
	public Optional<EmployeeEntity> getEmployeeById(Integer empId) {
		String sql = "Select * from employee where empId = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, empId);
			
			// Better for dynamic data
			// This does lazy loading
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsm = rs.getMetaData();
			rsm.getColumnCount();
			
//			rs.next(); // points to next row
//			rs.getString(2); // This loads data at runtime
			
			if(rs.next()) return Optional.of(new EmployeeEntity(empId, rs.getString(2)));
			
		} catch (SQLException e) {
//			e.printStackTrace();
		}
		
		return Optional.empty();
	}

	@Override
	public Optional<List<EmployeeEntity>> getAllEmployees() {
		String sql = "Select * from employee";
		try {
			PreparedStatement ps =  connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<EmployeeEntity> list = new ArrayList<>();
			while(rs.next()) {
				list.add(new EmployeeEntity(rs.getInt(1), rs.getString(2)));
			}
			
			return Optional.of(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Optional.empty();
	}
	
}
