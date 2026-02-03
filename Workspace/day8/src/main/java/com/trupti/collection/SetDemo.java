package com.trupti.collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.trupti.onetoone.Car;
import com.trupti.onetoone.Driver;
import com.trupti.util.HibernateUtil;

public class SetDemo {
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		try(Session session = factory.openSession()) {
			
			Transaction tx = session.beginTransaction();
			
//			Set<Certificate> certificates = new HashSet<>();
//			certificates.add(new Certificate(0, "AI"));
//			certificates.add(new Certificate(0, "JAVA"));
//
//			Employee employee = new Employee(0, "Trupti", "Balbudhe", 5000, certificates);
//			session.save(employee); 
			
			Driver driver = new Driver();
			Car car = new Car(); 
			
			driver.setName("Trupti");
			car.setBrand("MyCAR");
			car.setHorsepower(500);
			driver.setCar(car);
			
			session.save(driver);

			tx.commit();
			System.out.println("Success!");
						
		} catch (Exception e) {
			System.out.println("Problem in the main function");
			e.printStackTrace();
		}
		
	}
}
