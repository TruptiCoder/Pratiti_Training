package com.trupti;

import com.trupti.a.A;
import com.trupti.c.C;
import com.trupti.model.*;

public class MainApp {

	public static void main(String[] args) {
		// This is fully qualified class name
		// new com.trupti.model.Employee();
		
//		Employee employee = new Employee(1, "Trupti");
//		System.out.println(employee);
//		employee.setId(30);
//		System.out.println(employee);
//		
//		int id = employee.getId();
//		System.out.println(id);
//		
//		String name = employee.getName();
//		System.out.println(name);
//		
//		new Department();
//		
//		OverloadingI o1 = new OverloadingDemo();
//		o1.over1(5);
//		o1.over1((byte)5);
		
		A a = new A();
		
		C c = new A();
		c.methodC();
	}
	
	public static void t1(C c) {
		A a = (A)c;
		tp(a);
	}
	
	public static void tp(A a) {
		a.methodC();
	}

}
