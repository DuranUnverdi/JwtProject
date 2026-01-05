package com.duranunverdi.starter.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.duranunverdi.starter"})
@EntityScan	(basePackages = {"com.duranunverdi.starter.model"})
@EnableJpaRepositories(basePackages = {"com.duranunverdi.starter.repository"})
@SpringBootApplication
public class JwtApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(JwtApplicationStarter.class, args);
	}

}
