package com.trupti.view;

import java.util.Scanner;
import java.util.logging.Logger;

import com.trupti.MainApp;
import com.trupti.model.Employee;
import com.trupti.service.EmployeeService;


public class EmployeeView {
	
	private static final Logger log = Logger.getLogger(MainApp.class.getName());

	private Scanner sc = new Scanner(System.in);
	
	private EmployeeService service = new EmployeeService();
	
	public EmployeeView() {
		employeeOptions();
	}

	private void employeeOptions() {
		int choice = 1;
		do {
			System.out.println("===========Employee Options==========");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employee");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. Exit");
			
			System.out.println("Enter Choice...");
			choice = getInteger();
			
			selectedOption(choice);
		} while(choice != 5);
	}

	private void selectedOption(int choice) {
		switch(choice) {
			case 1: {
				addEmployee();
				break;
			}
			case 2: {
				getEmployees();
				break;
			}
			case 3: {
				updateEmployees();
				break;
			}
			case 4: {
				DeleteEmployees();
				break;
			}
			case 5: {
				exitEmployee();
				break;
			}
			default: {
				log.warning("Unexpected value " + choice);
				throw new IllegalArgumentException("Unexpected Choice " + choice);
			}
		}
	}
	
	private int getInteger(){
		while (!sc.hasNextInt()) {
	        System.out.println("Please enter a valid integer:");
	        sc.next(); // discard invalid input
	    }
	    return sc.nextInt();
	}

	private void DeleteEmployees() {
		System.out.println("Enter id of Employee you want to delete");
		int empId = getInteger();
		if(service.verifyId(empId)) {
			service.deleteEmployee(empId);
		}
	}

	private void updateEmployees() {
		System.out.println("Enter id of Employee you want to update");
		int empId = getInteger();
		
		if(service.verifyId(empId)) {
			
			System.out.println("1. Update Id");
			System.out.println("2. Update name");
			System.out.println("3. Update city");
			System.out.println("4. Update name and city both");
			System.out.println("Enter your choice");
			
			int choice = getInteger();
			
			switch(choice) {
				case 1: {
					System.out.println("Enter new Id: ");
					int newEmpId = getInteger();
					if(!service.verifyId(newEmpId)) {
						service.updateId(empId, newEmpId);		
						System.out.println("id: " + empId + " is updated to " + newEmpId);
					}
					break;
				}
				case 2: {
					System.out.println("Enter new name");
					String newName = sc.next();
					service.updateName(empId, newName);
					System.out.println("For id: " + empId + " name is updated to " + newName);
					break;
				}
				case 3: {
					System.out.println("Enter new city");
					String newCity = sc.next();
					service.updateCity(empId, newCity);
					System.out.println("For id: " + empId + " city is updated to " + newCity);
					break;
				}
				case 4: {
					System.out.println("Enter new name");
					String newName = sc.next();
					System.out.println("Enter new city");
					String newCity = sc.next();
					service.updateNameAndCity(empId, newName, newCity);
					System.out.println("For id: " + empId + " name is " + newName + " and city is " + newCity);
					break;
				}
				default: {
					log.warning("Unexpected value " + choice);
					throw new IllegalArgumentException("Unexpected Choice " + choice);
				}
			}
			
		} else System.out.println("Id: " + empId + " does not exists");
		
		System.out.println("Do you want to continue to update? (Y/N)");
		String ch = sc.next();
		
		if(ch.equalsIgnoreCase("Y")) updateEmployees();
	}

	private void exitEmployee() {
		sc.close();
		System.out.println("Thank You, Come Again");
		System.exit(0);
	}

	private void addEmployee() {
		String c = "n";
		int empCount = 0;
		Employee[] employees = new Employee[10];
		
		do {
			System.out.println("Enter Employee Id");
			int empId = getInteger();
			sc.nextLine();
			
			if(service.verifyId(empId)) {
				System.out.println("Id " + empId + " already exists");
				continue;
			}
			
			System.out.println("Enter Employee Name");
			String empName = sc.nextLine();
			System.out.println("Enter Employee City");
			String empCity = sc.nextLine();
			
			Employee e =  new Employee(empId, empName, empCity);
			employees[empCount++] = e;
			
			System.out.println("Employee Added: " + e);
			
			System.out.println("Do you want to more employees? Y/N");
			c = sc.next();
			
		} while(c.equalsIgnoreCase("Y") && empCount < 10);
		
		if(empCount == 10) System.out.println("Only 10 entries can be added at a time!");
		
		service.addEmployeeService(employees);
	}
	
	private void getEmployees() {
		Employee employees[] = service.getEmployees();
		System.out.println("ID\tName\tCity");
		for(Employee e : employees) {
			if(e != null) System.out.println(e.getEmpId() + "\t" + e.getEmpName() + "\t" + e.getEmpCity());
		}
	}
}
