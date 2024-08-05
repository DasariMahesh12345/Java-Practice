package com.emr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emr.model.Employee;

@Service
public interface EmployeeService {

	Employee createEmployee(Employee empRequest);

	List<Employee> getEmployees();
	
	Employee updateEmployee(int id, Employee empRequest);

	

}
