package com.trupti.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.trupti.onetoone.Car;
import com.trupti.onetoone.Driver;

public class HibernateUtil {
	
	private static SessionFactory factory;
	
	static {
		Configuration configuration = new Configuration();
		configuration.configure();
//		configuration.addAnnotatedClass(Employee.class);
//		configuration.addAnnotatedClass(Certificate.class);
		configuration.addAnnotatedClass(Driver.class);
		configuration.addAnnotatedClass(Car.class);
		factory = configuration.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	
}