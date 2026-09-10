package com.instantsystem.parkingaroundme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ParkingaroundmeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingaroundmeApplication.class, args);
	}

}
