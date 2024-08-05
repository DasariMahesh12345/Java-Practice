package com.login.reg.email.verify.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.login.reg.email.verify.entity.User;
@Service
public interface UserService {
	  ResponseEntity<?> saveUser(User user);

	    ResponseEntity<?> confirmEmail(String confirmationToken);

		

}
