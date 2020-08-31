package com.partnera.rezervationapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.partnera.rezervationapp.Entities.Employee;
import com.partnera.rezervationapp.Service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private IEmployeeService employeeService;
    
	@Autowired
	public EmployeeController(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/getEmployee")
	public ResponseEntity<List<Employee>> getEmployeeAll(){
		List<Employee> employees=employeeService.getAllEmployee();
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}
	
	@GetMapping("/getEmployeePosition/{id}")
	public ResponseEntity<String> getEmployeePosition(@PathVariable("id") int id){
		return ResponseEntity.ok(employeeService.getPositionEmployee(id)) ;	
	}
	
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id){
		Employee employee=employeeService.getByIdEmployee(id);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	@PostMapping("/createEmployee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		return ResponseEntity.ok(employeeService.addEmployee(employee));
	}
	
	@PutMapping("/updateEmployee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		return ResponseEntity.ok(employeeService.updateEmployee(employee));
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<Boolean> deleteCity(@PathVariable("id") int id){
		return ResponseEntity.ok(employeeService.deleteEmployee(id));
	}
	

}
