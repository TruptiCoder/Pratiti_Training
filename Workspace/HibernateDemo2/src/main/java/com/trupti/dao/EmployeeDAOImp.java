package com.trupti.dao;

import java.io.Serializable;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.trupti.entity.EmployeeEntity;
import com.trupti.util.HibernateUtil;

public class EmployeeDAOImp implements EmployeeDAO {
	
	private SessionFactory factory;
	
	{
		factory = HibernateUtil.getFactory();
	}
	
	@Override
	public Optional<EmployeeEntity> addEmployee(EmployeeEntity employeeEntity) {
		Transaction transaction = null;
		try(Session session = factory.openSession();) {
			
			transaction = session.beginTransaction();
			
			Serializable e = session.save(employeeEntity);
			
			if(employeeEntity.getEmpId() == e) {
				transaction.commit();
				return Optional.of(employeeEntity);
			}
			
		} catch (Exception e) {
			transaction.rollback();
		}
		
		return Optional.empty();

	}
	
	public Optional<EmployeeEntity> getById(Integer empId) {
		try(Session session = factory.openSession();) {
			
			// difference between get and load (read)
			EmployeeEntity employeeEntity = session.get(EmployeeEntity.class, empId);
			if(employeeEntity != null) {
				return Optional.of(employeeEntity);
			}
			
		} catch (Exception e) {
			System.err.println("Error in getById");
		}
		
		return Optional.empty();
	}
	
}
