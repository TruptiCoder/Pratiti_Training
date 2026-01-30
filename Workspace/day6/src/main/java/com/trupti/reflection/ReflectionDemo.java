package com.trupti.reflection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionDemo {
	
	public ReflectionDemo() {
//		Person p = new Person();
		displayObjectInfo();
	}

	private void displayObjectInfo() {
//		System.out.println(p);
		
//		Class c = Person.class;
		
//		Scanner scanner = new Scanner(System.in);
		Properties properties = new Properties();
		try {
			properties.load(new FileReader("src/main/resources/myInfo.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String c1 = properties.getProperty("myClass");
		
//		System.out.println("Enter class to load");
//		String c1 = scanner.next();
		
		
		try {
			Class<?> c = Class.forName(c1);
			System.out.println(c1);
			System.out.println(c.getName());
			System.out.println(c.getPackageName());
			System.out.println(c.getModifiers());
			Object o = c.getDeclaredConstructor().newInstance();
			
//			PersonAbstract p = (PersonAbstract) o;
//			p.tp();
			
			Method[] methods = c.getMethods(); // This returns only public and inherited methods
			Method[] decalredMethods = c.getDeclaredMethods();
			Method tp = c.getMethod("tp", null);
			tp.invoke(o);
			
			for(Method mm : decalredMethods) {
				System.out.println(mm.getName());
				if(mm.getName() == "tpp") {
					mm.setAccessible(true);
					mm.invoke(o);					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
