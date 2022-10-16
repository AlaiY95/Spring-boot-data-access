package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// @RestController makes the bellow class serve Rest endpoints (@GetMapping)
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    //reference to StudentService
    private final StudentService studentService;

    // add to constructor
    // Dependency injection - Injecting StudentService above into below constructor
    // Anythign we pass into this StudentService should be injected into the StudentController using @AutoWired
    @Autowired
    public StudentController(StudentService studentService) {
        // Initializing Private Final StudentService variable
        this.studentService = studentService;
    }

    //In order for ths method to be served as a RESTful endpoint, we annotate with:
    @GetMapping
    //We now have a GetMapping for Studentcontroller
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
}
