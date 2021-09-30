package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Assignmnet2Application {

	public static void main(String[] args) {
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Calculator calculation = factory.getBean(Calculator.class);
		calculation.calculate();
		
		
	}

}
