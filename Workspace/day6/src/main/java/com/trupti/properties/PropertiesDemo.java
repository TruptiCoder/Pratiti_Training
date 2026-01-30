package com.trupti.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
	
	public PropertiesDemo() {
		
		Properties properties = new Properties();
//		properties.put("fName", "Trupti");
//		properties.put("lName", "Balbudhe");
//		
//		try {
//			properties.store(new FileWriter("empdata.properties"), "Employee Data");
//			System.out.println("Saved the file........");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		try {
			properties.load(new FileReader("empdata.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String p = properties.getProperty("fName");
		System.out.println(p);
		
	}
	
}
