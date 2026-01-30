package com.trupti.set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import com.trupti.model.Employee;

public class setDemo {

	public void example1() {

		Employee employee1 = new Employee(1, "Trupti1");
		Employee employee2 = new Employee(2, "Trupti2");
		Employee employee3 = new Employee(3, "Trupti3");
		Employee employee4 = new Employee(4, "Trupti4");

//		System.out.println(employee.id());
//		System.out.println(employee.name());
//		System.out.println(employee.equals(employee));

		Set<Employee> set = new HashSet<>();

		System.out.println(set.add(employee4));
		System.out.println(set.add(employee2));
		System.out.println(set.add(employee1));
		System.out.println(set.add(employee3));
		
		set.forEach(e -> {
			System.out.println("id: " + e.getId() + " Name: " + e.getName().toUpperCase());
		});
		
		System.out.println(set.stream().filter((e) -> e.getId() == 2).count());
		
		Comparator<Employee> byId = new Comparator<Employee>() {
			
			@Override
			public int compare(Employee o1, Employee o2) {
				return o2.getId() - o1.getId();
			}
		};
		
		set.stream().sorted((e1, e2) -> e2.getId() - e1.getId()).forEach(System.out::println);

	}

}
