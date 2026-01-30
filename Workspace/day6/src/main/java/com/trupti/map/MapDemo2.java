package com.trupti.map;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

import com.trupti.model.Employee;

public class MapDemo2 {
	
	static HashMap<Integer, Employee> map ;
	
	static {
		boolean r = new File("employees.ser").exists();
		if(r) {
			try {
				FileInputStream fis = new FileInputStream("employees.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);
				map = (HashMap<Integer, Employee>) ois.readObject();
				
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		else {
			map = new HashMap<Integer, Employee>();
		}
	}
	
	public void example1() {
		
		map.put(6, new Employee(6, "Trupti6"));
		
		map.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
		
	}
	
}
