package com.partnera.rezervationapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.partnera.rezervationapp.Entities.Employee;
import com.partnera.rezervationapp.Repository.IEmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService{
	
	private IEmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(IEmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployee() {
		return this.employeeRepository.getAllEmployee();
	}

	@Override
	@Transactional
	public Employee addEmployee(Employee employee) {
		this.employeeRepository.addEmployee(employee);
		return employee;
	}

	@Override
	@Transactional
	public Employee updateEmployee(Employee employee) {
		this.employeeRepository.updateEmployee(employee);
		return employee;
	}

	@Override
	@Transactional
	public Boolean deleteEmployee(int id) {
		this.employeeRepository.deleteEmployee(id);
		return true;
	}

	@Override
	@Transactional
	public Employee getByIdEmployee(int id) {
		return this.employeeRepository.getByIdEmployee(id);
	}

	@Override
	@Transactional
	public Employee getByNameEmployee(String fullName) {
		return this.employeeRepository.getByNameEmployee(fullName);
	}

	@Override
	public String getPositionEmployee(int id) {
		return this.employeeRepository.getPositionEmployee(id);
	}

}
