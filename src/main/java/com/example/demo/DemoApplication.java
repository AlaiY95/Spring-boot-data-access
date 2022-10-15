package com.example.demo;

import com.example.demo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
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
	public List<Student> hello() {
		return List.of(
				new Student(
						1L,
						"Mariam",
						"mariam.jamal@gmail.com",
						LocalDate.of(2000, Month.JANUARY, 5),
						21

				)

		);
	}

}
