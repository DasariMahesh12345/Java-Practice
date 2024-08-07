package com.jwt.authentaction.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.jwt.authentaction.repository.UserRepository;

@Component("userSecurity")
public class UserSecurity {
	@Autowired
	UserRepository userRepo;

	public boolean hasUserId(Authentication authentication, Integer userId) {

		int userID = userRepo.findByUserName(authentication.getName()).getUserId();
//		System.out.println(userId+"  "+userID);
		if (userID == userId)
			return true;

		return false;

	}
}
