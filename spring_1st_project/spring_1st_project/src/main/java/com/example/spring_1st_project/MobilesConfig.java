package com.example.spring_1st_project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MobilesConfig {
	@Bean
	public Mobiles getoneplusobj() {
		return new oneplus();
	}
	@Bean
	public Mobiles getiphoneobj() {
		return new iphone();
	}
	
	
	}

