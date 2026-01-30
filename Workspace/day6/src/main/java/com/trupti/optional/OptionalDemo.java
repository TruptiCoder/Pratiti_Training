package com.trupti.optional;

import java.util.Optional;

record Employee(Integer id, String name) {
	
}

public class OptionalDemo {

	public OptionalDemo() {
		addEmployee(new Employee(1, "Trupti"));
		Optional<Employee> ep = getEmployeeById(2);
		if (ep.isPresent()) {
			Employee e = ep.get();
			System.out.println(e.id());
			System.out.println(e.name());			
		}
		else System.out.println("NOOOOooooOOOOOOooooo");
	}
	
	private Optional<Employee> getEmployeeById(int i) {
		Employee e = new Employee(2, "YESSSSSSSssssssSSSS");
		return Optional.ofNullable(e);
	}

	public void addEmployee(Employee... employees) {
		for(Employee e : employees) {
			System.out.println(e);
		}
	}
	
}
