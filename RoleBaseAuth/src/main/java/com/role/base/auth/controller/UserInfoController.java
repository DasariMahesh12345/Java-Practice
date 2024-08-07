package com.role.base.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.role.base.auth.entity.UserInfo;
import com.role.base.auth.service.UserInfoService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserInfoController {
	@Autowired
	private UserInfoService service;
	
	@PostMapping("/new")
	public ResponseEntity<String> addNewUser(@RequestBody UserInfo userInfo){
		return new ResponseEntity<String> (service.addUser(userInfo), HttpStatus.CREATED);
	}

}
