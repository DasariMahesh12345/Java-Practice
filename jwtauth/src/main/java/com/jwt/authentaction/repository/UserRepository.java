package com.jwt.authentaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwt.authentaction.service.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserName(String userName);
}
