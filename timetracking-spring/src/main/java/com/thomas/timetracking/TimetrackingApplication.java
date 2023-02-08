package com.thomas.timetracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TimetrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimetrackingApplication.class, args);
	}

}
