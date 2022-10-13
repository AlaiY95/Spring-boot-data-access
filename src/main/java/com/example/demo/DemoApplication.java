package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
// @RestController makes the bellow class serve Rest endpoints (@GetMapping)
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	//In order for ths method to be served as a RESTful endpoint, we annotate with:
	@GetMapping
	public List<String> hello() {
		return List.of("Hello", "World");
	}

}
