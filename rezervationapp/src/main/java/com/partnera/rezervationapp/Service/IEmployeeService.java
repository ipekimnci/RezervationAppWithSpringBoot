package com.partnera.rezervationapp.Service;

import java.util.List;

import com.partnera.rezervationapp.Entities.Employee;

public interface IEmployeeService {
	List<Employee> getAllEmployee();
	Employee addEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	Boolean deleteEmployee(int id);
	Employee getByIdEmployee(int id);
	Employee getByNameEmployee(String fullName);
	String getPositionEmployee(int id);

}
