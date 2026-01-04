package com.example.devpulse; // Make sure this matches your package structure!

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevpulseApplication {

	public static void main(String[] args) {
		// The error was likely here: 'DemoApplication.class' -> 'DevpulseApplication	.class'
		SpringApplication.run(DevpulseApplication.class, args);
	}

}
