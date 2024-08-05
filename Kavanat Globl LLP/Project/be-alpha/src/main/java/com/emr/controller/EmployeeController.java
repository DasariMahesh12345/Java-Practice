package com.emr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emr.model.Employee;
import com.emr.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/hello")
	public String echo() {
		return "Hello World!";
	}

	@PostMapping("/employee/add")
	public ResponseEntity<String> createEmployee(@RequestBody Employee empRequest) {

		Employee employee = employeeService.createEmployee(empRequest);

		return ResponseEntity.status(200).body("Employee Created Successfully with Id " + employee.getId());
	}

	@GetMapping("/employee/list")
	public List<Employee> getEmployees() {

		return employeeService.getEmployees();
	}
	@PutMapping("/employee/update/{id}")
	public ResponseEntity<String> updateEmployee(@RequestParam int id, @RequestBody Employee empRequest) {
		Employee employee = employeeService.updateEmployee(id,empRequest);

		return ResponseEntity.status(200).body("Employee record updated Successfully with Id " + employee.getId());
	}
	}

