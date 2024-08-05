package com.teluguskillhub2.mvc.model;
@Entity
public class Customer {
	@Id
	@GeneratedValue
private long id;
private string firstname;
private string lasttname;
private string email; 


public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public string getFirstname() {
	return firstname;
}
public void setFirstname(string firstname) {
	this.firstname = firstname;
}
public string getLasttname() {
	return lasttname;
}
public void setLasttname(string lasttname) {
	this.lasttname = lasttname;
}
public string getEmail() {
	return email;
}
public void setEmail(string email) {
	this.email = email;
}

}
