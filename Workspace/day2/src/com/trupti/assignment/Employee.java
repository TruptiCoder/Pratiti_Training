package com.trupti.assignment;

public class Employee {
	static int count = 0;
	int id;
	String name;
	String city;
	
	public Employee(int id, String name) {
		this(id, name, "");
	}
	
	public Employee(int id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
		count++;
	}
}
