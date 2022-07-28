package com.id.danafix.codingtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.id.danafix.codingtest.model.Employee;
import com.id.danafix.codingtest.model.ResponseModel;
import com.id.danafix.codingtest.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

	@Autowired 
	private EmployeeService employeeService;
	
	
	
	@GetMapping
	private ResponseModel<Employee>getEmployee(){
		return employeeService.getEmployee();
	}
	
	@PutMapping("/{id}")
	private ResponseModel<Employee>editEmployee(@RequestBody Employee employee,@PathVariable("id") Integer id){
		return employeeService.editEmployee(employee,id);
	}
	
	@PostMapping
	private ResponseModel<Employee>addEmployee(@RequestBody Employee employee){
		return employeeService.addEmployee(employee);
	}
	
	@DeleteMapping("/{id}")
	private ResponseModel<Employee>deleteEmployee(@PathVariable("id") Integer id){
		return employeeService.removeEmployee(id);
	}
}
