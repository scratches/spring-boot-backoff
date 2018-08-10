package com.example;

import com.backoff.BackoffSpringApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StarterApplication {

	private static int count = 0;

	@GetMapping("/")
	public String home() {
		return "Hello World";
	}

	@Bean
	public CommandLineRunner runner() {
		return args -> {
			if (count++ < 2) {
				throw new IllegalStateException("Planned");
			}
		};
	}

	public static void main(String[] args) {
		BackoffSpringApplication.run(StarterApplication.class, args);
	}

}
