package com.emr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.model.Employee;
import com.emr.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee empRequest) {
		// TODO Auto-generated method stub
		return employeeRepository.save(empRequest);
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	public Employee updateEmployee(int id, Employee empRequest) {
		// TODO Auto-gene rated method stub
		Employee emp = employeeRepository.getById(null);
		emp.setName(empRequest.getName());
		//emp.setId(empRequest.getId());
		emp.setMobile(empRequest.getMobile());
		return employeeRepository.getById(null);
	}

}
