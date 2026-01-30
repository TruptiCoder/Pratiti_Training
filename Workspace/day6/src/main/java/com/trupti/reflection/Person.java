package com.trupti.reflection;

abstract class PersonAbstract {
	public abstract void tp();
}

public final class Person extends PersonAbstract {
	static {
		System.out.println("Person class loaded");
	}
	
	public Person() {
		System.out.println("-----------------Person object created--------------");
	}
	
	@Override
	public void tp() {
		System.out.println("tp method called");
	}
}

final class Employee extends PersonAbstract {
	static {
		System.out.println("Employee class loaded");
	}
	
	public Employee() {
		System.out.println("-----------------Employee object created--------------");
	}
	
	@Override
	public void tp() {
		System.out.println("tp method in employee called");
	}
	
	private void tpp() {
		System.out.println("tpp in employee");
	}
}
