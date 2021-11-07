package com.funWorkout.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

@SpringBootApplication(scanBasePackages = "com.funWorkout")
@EntityScan("com.funWorkout.models")
@EnableJpaRepositories("com.funWorkout.repositories")
public class FunWorkoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(FunWorkoutApplication.class, args);
	}

}
