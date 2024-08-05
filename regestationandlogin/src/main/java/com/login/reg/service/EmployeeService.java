package com.login.reg.service;

import org.springframework.stereotype.Service;

import com.login.reg.model.EmployeeDTO;
import com.login.reg.model.LoginDTO;
import com.login.reg.response.LoginMesage;

@Service
public interface EmployeeService {
	String addEmployee(EmployeeDTO employeeDTO);
    LoginMesage loginEmployee(LoginDTO loginDTO);
	boolean isEmailExists(String email);
    
	
	

}
