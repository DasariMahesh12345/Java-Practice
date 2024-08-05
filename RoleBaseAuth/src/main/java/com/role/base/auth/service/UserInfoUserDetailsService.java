package com.role.base.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.role.base.auth.config.UserInfoUserDetails;
import com.role.base.auth.entity.UserInfo;
import com.role.base.auth.repository.UserInfoRepository;

@Component
public class UserInfoUserDetailsService implements UserDetailsService  {
	 @Autowired
	    private UserInfoRepository repository;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Optional<UserInfo> userInfo = repository.findByUname(username);
	        return userInfo.map(UserInfoUserDetails::new)
	                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

	    }

}
