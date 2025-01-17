package com.taehoondev.daylink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DaylinkApplication {
	public static void main(String[] args) {
		SpringApplication.run(DaylinkApplication.class, args);
	}

}
