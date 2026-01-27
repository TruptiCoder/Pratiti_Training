package com.trupti.dao;

import com.trupti.model.Employee;

public class EmployeeDAO {
	
	private static Employee employees[] = new Employee[50];
	
	static {
		employees[0] = new Employee(1, "TRUPTI", "Pune");
		employees[1] = new Employee(2, "SHWETA", "Chandrapur");
		employees[2] = new Employee(3, "GAURI", "Akola");
		employees[3] = new Employee(4, "SHIV", "Kolhapur");
	}
	
	public static void main(String args[]) {
		// This is to test methods in this class
		EmployeeDAO dao = new EmployeeDAO();
		Employee[] emps = dao.getEmployees();
		
		for(Employee e : emps) {
			System.out.println(e);
		}
	}
	
	public void addEmployee(Employee...emps) {
		for(Employee emp : emps) {
			if(emp != null) {
				for(int i = 0; i < employees.length; i++) {
					if(employees[i] == null) {
						employees[i] = emp;
						break;
					}
				}
			}
		}
	}
	
	public Employee[] getEmployees() {
		Employee e[] = new Employee[getEmployeeCount()];
		int idx = 0;
		for(int i = 0; i < employees.length; i++) {
			if(employees[i] != null) {
				e[idx++] = employees[i];
			}
		}
		
		return e;
	}

	public boolean getId(int empId) {
		for(Employee e : employees) {
			if(e != null && e.getEmpId() == empId) return true;
		}
		return false;
	} 
	
	private static int getEmployeeCount() {
		int count = 0;
		for(Employee e : employees) {
			if(e != null) count++;
		}
		return count;
	}
}
