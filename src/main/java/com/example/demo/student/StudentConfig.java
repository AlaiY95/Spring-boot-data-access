package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@Configuration
public class StudentConfig implements CommandLineRunner {

    @Autowired
    private StudentRepository repository;

    @Override
    public void run(String... args) throws Exception {

        Student mariam = new Student(
                "Mariam",
                "mariam.jamal@gmail.com",
                LocalDate.of(2000, Month.JANUARY, 5)
        );

        Student alex = new Student(
                "Alex",
                "alex@gmail.com",
                LocalDate.of(2004, Month.JANUARY, 5)
        );

        // invoke repository where we have the ability to save 1 student or list of all
        repository.saveAll(
                List.of(mariam, alex)
        );
    }
}


