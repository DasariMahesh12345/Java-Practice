package com.example.spring_1st_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Spring1stProjectApplication {

	public static void main(String[] args) {
		//spring bean container
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MobilesConfig.class);
		Mobiles obj = context.getBean("getoneplusObj",Mobiles.class);
		
	   obj.getModelAndColor();
		
		
		
	}
	
}


