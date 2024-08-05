package com.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.batch")
public class BatchprocessApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchprocessApplication.class, args);
	}

}
