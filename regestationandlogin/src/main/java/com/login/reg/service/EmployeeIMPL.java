package com.login.reg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.login.reg.model.Employee;
import com.login.reg.model.EmployeeDTO;
import com.login.reg.model.LoginDTO;
import com.login.reg.repository.EmployeeRepo;
import com.login.reg.response.LoginMesage;

@Service
public class EmployeeIMPL implements EmployeeService{
	 @Autowired
	    private EmployeeRepo employeeRepo;
	    @Autowired
	    private PasswordEncoder passwordEncoder;
	    
	  
	    @Override
	    public String addEmployee(EmployeeDTO employeeDTO) {
	        Employee employee = new Employee(
	                employeeDTO.getEmployeeid(),
	                employeeDTO.getEmployeename(),
	                employeeDTO.getEmail(),
	               this.passwordEncoder.encode(employeeDTO.getPassword())
	        );
	        employeeRepo.save(employee);
	       // return employee.getEmployeename();
	        return "Employee: "  +employee.getEmployeename()+ " Registered successfully!"+"employee_id"+employee.getEmployeeid();
	    
	    }
	    EmployeeDTO employeeDTO;
	    @Override
	    public LoginMesage  loginEmployee(LoginDTO loginDTO) {
	        String msg = "";
	        Employee employee1 = employeeRepo.findByEmail(loginDTO.getEmail());
	        if (employee1 != null) {
	            String password = loginDTO.getPassword();
	            String encodedPassword = employee1.getPassword();
	            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
	            if (isPwdRight) {
	                Optional<Employee> employee = employeeRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
	                if (employee.isPresent()) {
	                    return new LoginMesage("Login Success", true);
	                } else {
	                    return new LoginMesage("Login Failed", false);
	                }
	            } else {
	                return new LoginMesage("password Not Match", false);
	            }
	        }else {
	            return new LoginMesage("Email not exits", false);
	        }
	    }
		
		   public boolean isEmailExists(String email) {
		        // Use the repository to query the database for an employee with the given email
		        Employee employee = employeeRepo.findByEmail(email);
		        return employee != null;
		    }
		   
	
	    

}
