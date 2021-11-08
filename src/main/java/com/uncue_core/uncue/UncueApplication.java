package com.uncue_core.uncue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class UncueApplication {

	public static void main(String[] args) {
		SpringApplication.run(UncueApplication.class, args);
	}

}
