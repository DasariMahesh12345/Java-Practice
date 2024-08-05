package com.login.reg.email.verify.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.reg.email.verify.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsByUserEmail(String userEmail);

	User findByUserEmailIgnoreCase(String userEmail);

}
