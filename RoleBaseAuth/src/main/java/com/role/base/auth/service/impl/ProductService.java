package com.role.base.auth.service.impl;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.role.base.auth.entity.UserInfo;
import com.role.base.auth.repository.UserInfoRepository;

public interface ProductService extends  UserDetailsService {

	@Autowired
	private UserInfoRepository repository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	boolean flag;
	public String addUser(UserInfo userInfo) {
		
		List<UserInfo> userList = repository.findAll();
		System.out.println(flag);
		System.out.println(userList);
		if(null != userList) {
			for(UserInfo user : userList) {
				if(user.getUname().equals(userInfo.getUname()))
					flag = true;
				else
					flag = false;
			}
		}
		System.out.println(flag);
		if(flag) {
			return "User already exists";
		} else {
			System.out.println(userInfo);
			System.out.println(userInfo.getUname());
			System.out.println(userInfo.getPwd());
			System.out.println(userInfo.getRole());
			System.out.println(userInfo.getId());
			userInfo.setPwd(passwordEncoder.encode(userInfo.getPwd()));
			repository.save(userInfo);
			return "User saved";
		}
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
