package com.example.LeaveRestApi;

import com.example.LeaveRestApi.config.config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(config.class)
public class LeaveRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeaveRestApiApplication.class, args);
	}

}
