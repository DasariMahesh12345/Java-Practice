package com.role.base.auth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_userinfo")
public class UserInfo {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String uname;
		private String pwd;
		private String role;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUname() {
			return uname;
		}
		public void setUname(String uname) {
			this.uname = uname;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}

		
}
