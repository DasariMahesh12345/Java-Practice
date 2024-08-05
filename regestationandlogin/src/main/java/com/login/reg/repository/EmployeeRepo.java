package com.login.reg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.reg.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer>{
	Optional<Employee> findOneByEmailAndPassword(String email, String password);
    Employee findByEmail(String email);
    

}
