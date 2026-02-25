package com.trupti.bean;

public class HelloBean {
	
	private String name;
	
	{
		System.out.println("HelloBean object created");
	}
	
	public void mainAaya() {
		System.out.println("Pranam sahab");
	}
	
	public void mainGaya() {
		System.out.println("Alvida doston, dua mein yaad rakhna");
	}
	
	public HelloBean(String name) {
		this.name = name;
	}
	
	public void greet() {
		System.out.println("Welcome to the world of Spring");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
