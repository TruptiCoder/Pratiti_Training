package com.trupti.map;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import com.trupti.model.Employee;

public class MapDemo {
	
	HashMap<Integer, Employee> map = new HashMap<>();
	
	public void example1() {
		
		Employee employee1 = new Employee(1, "Trupti1");
		Employee employee2 = new Employee(2, "Trupti2");
		Employee employee3 = new Employee(3, "Trupti3");
		Employee employee4 = new Employee(4, "Trupti4");
		Employee employee5 = new Employee(5, "Trupti5");
		
		addEmployees(employee1, employee2, employee3, employee4, employee5);
		
		save();
		
//		System.out.println(map.put(1, employee1));
//		System.out.println(map.putIfAbsent(2, employee2));
//		System.out.println(map.putIfAbsent(3, employee3));
//		System.out.println(map.putIfAbsent(4, employee4));
		
//		BiConsumer<Integer, Employee> consumer = new BiConsumer<Integer, Employee>() {
//			
//			@Override
//			public void accept(Integer t, Employee u) {
//				System.out.println("Key: " + t + " Value: " + u);
//				
//			}
//		};
		
		map.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));

		System.out.println(map.entrySet().stream().filter(e -> e.getValue().getName().equals("Trupti3")).count());
		
	}

	private void addEmployees(Employee... employees) {
		
		for(Employee e : employees) {
			map.put(e.getId(), e);
		}
		
	}
	
	public void save() {
		try (FileOutputStream fos = new FileOutputStream("employees.ser"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			
			oos.writeObject(map);
			System.out.println("Saved..........!");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
}
