package com.whatdy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@ComponentScan(basePackages = "com.whatdy")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
