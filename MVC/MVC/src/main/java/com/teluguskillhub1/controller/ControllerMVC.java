package com.teluguskillhub1.controller;

import com.teluguskillhub2.mvc.model.Customer;

import.org.springframework.stereotype.controller;


@controller
public class ControllerMVC {
	@Autowired
	CustomerRepo repo;
	
	@GetMapping(value="/")
	public String ethome() {
		return "home.jsp";
	}
@postMapping(value="/addCustomer")
public String addcustomer(Customer data Model,model) {
	repo.save(data);
	return"success.jsp";
}




}
