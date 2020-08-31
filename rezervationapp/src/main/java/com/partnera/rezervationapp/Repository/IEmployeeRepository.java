package com.partnera.rezervationapp.Repository;

import java.util.List;

import com.partnera.rezervationapp.Entities.Employee;


public interface IEmployeeRepository {
	List<Employee> getAllEmployee();
	void addEmployee(Employee employee);
	void updateEmployee(Employee employee);
	void deleteEmployee(int id);
	Employee getByIdEmployee(int id);
	Employee getByNameEmployee(String fullName);
	String getPositionEmployee(int id);

}
