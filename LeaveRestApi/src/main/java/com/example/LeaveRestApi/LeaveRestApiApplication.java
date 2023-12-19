package com.example.LeaveRestApi;

import com.example.LeaveRestApi.config.config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Import(config.class)
@EnableJpaRepositories("com.example.LeaveRestApi.repository")
@EntityScan("com.example.LeaveRestApi.models")
public class LeaveRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeaveRestApiApplication.class, args);
	}

}
