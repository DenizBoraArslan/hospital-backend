package com.db.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.db")
@EntityScan(basePackages = "com.db")
@SpringBootApplication
@ComponentScan(basePackages = {"com.db","com.db.repository"})
public class HospitalAutomationSystemApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(HospitalAutomationSystemApplicationStarter.class, args);
	}

}
