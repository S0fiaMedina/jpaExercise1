package com.jpaexercise.jpaexercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:messages.properties")
public class JpaexerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaexerciseApplication.class, args);
	}

}
