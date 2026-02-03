package com.trupti.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.trupti.entity.EmployeeEntity;
import com.trupti.util.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private SessionFactory factory = HibernateUtil.getSessionFactory();
	
	@Override
	public Optional<EmployeeEntity> addEmployee(EmployeeEntity employeeEntity) {
		
		try(Session session = factory.openSession();) {
			
			Transaction transaction = session.beginTransaction();
			session.save(employeeEntity); // saveOrUpdate: If id exists then update it, if not exits then create new
			transaction.commit();
			return Optional.of(employeeEntity);
		} catch (Exception e) {
			System.out.println("Error in addEmployee of EmployeeDAOImpl");
		}
		
		return Optional.empty();
		
	}
	
	public Optional<EmployeeEntity> getEmployeeById(Integer id) {
		try(Session session = factory.openSession()) {
			
			EmployeeEntity emp = session.find(EmployeeEntity.class, id);
			return Optional.ofNullable(emp);
			
		} catch (Exception e) {
			System.out.println("Error in getEmployeeById of EmployeeDAOImpl");
		}
		return Optional.empty();
	}
	
	public Optional<List<EmployeeEntity>> getAllEmployees() {
		try(Session session = factory.openSession()) {
			
			String hql = "from EmployeeEntity";
			Query query = session.createQuery(hql);
			
//			Query query = session.createNativeQuery("select * from EmployeeEntity", EmployeeEntity.class);
			
			List<EmployeeEntity> employeeEntities = query.getResultList();
			return Optional.ofNullable(employeeEntities);
			
		} catch (Exception e) {
			System.out.println("Error in getAllEmployee of EmployeeDAOImpl");
		}
		return Optional.empty();
	}
	
	public Optional<List<EmployeeEntity>> getByCity() {
		try(Session session = factory.openSession()) {
			
//			Query query = session.createNamedQuery("getByCity");
//			query.setParameter("city", "pune");
			
			Query query = session.createNamedQuery("getByFname");
			query.setParameter("fname", "Trupti");
			
			List<EmployeeEntity> employeeEntities = query.getResultList();
			return Optional.ofNullable(employeeEntities);
			
		} catch (Exception e) {
			System.out.println("Error in getByCity of EmployeeDAOImpl");
		}
		return Optional.empty();
	}
	
	public void deleteById() {
		try(Session session = factory.openSession()) {
			
			Transaction transaction = session.beginTransaction();
			
			EmployeeEntity ee = session.get(EmployeeEntity.class, 2);
			if(ee != null) {
				session.delete(ee);
			}
			
			transaction.commit();
			
		} catch (Exception e) {
			System.out.println("Error in deleteById of EmployeeDAOImpl");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
//		new EmployeeDAOImpl().addEmployee(new EmployeeEntity(1, "a", "b", "c"));
//		System.out.println(new EmployeeDAOImpl().getEmployeeById(2).get());
//		System.out.println(new EmployeeDAOImpl().getAllEmployees().get());
//		System.out.println(new EmployeeDAOImpl().getByCity().get());
		new EmployeeDAOImpl().deleteById();
		
	}
	
}
