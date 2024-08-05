package com.role.base.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.role.base.auth.entity.Product;
import com.role.base.auth.exception.ProductNotFoundException;
import com.role.base.auth.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product){
		return new ResponseEntity<Product> (productService.saveProduct(product), HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchAll")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<List<Product>> getAllCustomers(){
		return new ResponseEntity<List<Product>> (productService.fetchAllProducts(), HttpStatus.CREATED);
	}
	
	@GetMapping("/fetch/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	public Product getCustomer(@PathVariable Long id) throws ProductNotFoundException{
		return productService.fetchProduct(id);
	}
	

}
