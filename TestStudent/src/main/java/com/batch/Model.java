package com.batch;

import jakarta.persistence.Entity;

@Entity
public class Model {
	
	
	private int id;
	private String name;
	private Integer Roll;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRoll() {
		return Roll;
	}
	public void setRoll(Integer roll) {
		Roll = roll;
	}
	
	

}
