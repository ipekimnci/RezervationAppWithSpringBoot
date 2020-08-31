package com.partnera.rezervationapp.Repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.partnera.rezervationapp.Entities.Employee;

@Repository
public class EmployeeRepository implements IEmployeeRepository{
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployee() {
		Session session=entityManager.unwrap(Session.class);
		List<Employee> employees =session.createQuery("from Employee", Employee.class).getResultList();
		return employees;
	}

	@Override
	public void addEmployee(Employee employee) {
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
		
	}

	@Override
	public void deleteEmployee(int id) {
		Session session=entityManager.unwrap(Session.class);
		Employee employee=session.get(Employee.class, id);
		session.delete(employee);
		
	}

	@Override
	public Employee getByIdEmployee(int id) {
		Session session=entityManager.unwrap(Session.class);
		Employee employee=session.get(Employee.class, id);
		return employee;
	}

	@Override
	public Employee getByNameEmployee(String fullName) {
		Session session=entityManager.unwrap(Session.class);
		Employee employee=session.get(Employee.class, fullName);
		return employee;
	}

	@Override
	public String getPositionEmployee(int id) {
		Session session=entityManager.unwrap(Session.class);
		Employee employee=session.get(Employee.class, id);
		return employee.getPozition();
	}

	

}
