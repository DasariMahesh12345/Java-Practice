package com.login.reg.email.verify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.login.reg.email.verify.entity.User;
import com.login.reg.email.verify.service.UserService;

@RestController
public class UserController {
	 @Autowired
	    private UserService userService;

	    @PostMapping("/register")
	    public ResponseEntity<?> registerUser(@RequestBody User user) {
	        return userService.saveUser(user);
	    }

	    @PostMapping("/confirm-account")
	    public ResponseEntity<?> confirmUserAccount(@RequestParam("token")String confirmationToken) {
	        return userService.confirmEmail(confirmationToken);
	    }

}
