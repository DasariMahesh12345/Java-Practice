package com.role.base.auth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="table_product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message="Product name should not be null")
	@NotEmpty(message="Product name should not be empty")
	//@Column(name="product_name")
	private String name;
	@NotNull(message="Price name should not be null")
	@NotEmpty(message="Price name should not be empty")
	@Min(value = 10)
	@Max(value = 100000)
	private String price;
	@NotNull(message="Department name should not be null")
	@NotEmpty(message="Department name should not be empty")
	private String department;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	
}
