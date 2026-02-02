package com.trupti.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.trupti.entity.EmployeeEntity;

public class EmployeeUtil {
	
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(EmployeeEntity.class);
		configuration.configure();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		System.out.println("Hibernate session opened successfully");
		
		session.save(new EmployeeEntity(1, "Trupti"));
		tx.commit();
		
		session.clear();
		sessionFactory.close();
	}
	
}
