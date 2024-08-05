package com.login.reg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.reg.model.EmployeeDTO;
import com.login.reg.model.LoginDTO;
import com.login.reg.response.LoginMesage;
import com.login.reg.service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {
	@Autowired
    private EmployeeService employeeService;
    @PostMapping(path = "/save")
    
    public String saveEmployee(@RequestBody @Validated EmployeeDTO employeeDTO) {
        if (employeeService.isEmailExists(employeeDTO.getEmail())) {
            return "Email already exists in the database";
        } else {
            String id = employeeService.addEmployee(employeeDTO);
            return id;
        }
    }
  
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO)
    {
        LoginMesage loginResponse = employeeService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

}
