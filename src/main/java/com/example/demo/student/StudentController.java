package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    //reference
    private final StudentService studentService;
    // add to constructor
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //In order for ths method to be served as a RESTful endpoint, we annotate with:
    @GetMapping
    //We now have a GetMapping for Studentcontroller
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
}
