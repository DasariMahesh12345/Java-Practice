package com.login.reg.email.verify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.login.reg.email.verify.respository.UserRepository;

@SpringBootApplication

public class RegestationandemailverifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegestationandemailverifyApplication.class, args);
	}

}
