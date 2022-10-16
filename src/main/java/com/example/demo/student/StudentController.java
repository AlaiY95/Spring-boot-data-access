package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // Post is when you want to add new resources to your Student
    // In order for this to work, we need to add @PostMapping
    @PostMapping
    // We take the RequestBody (Payload) and map it to a student
    public void registerNewStudent(@RequestBody Student student) {
        // invoke the service
        studentService.addNewStudent(student);
    }

    // deleteStudent method using @DeleteMapping
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);


        @PutMapping(path = "{studentId}")
        public void updateStudent(
        @PathVariable(("studentId") Long studentId),
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String email) {
            studentService.updateStudent(studentId, name, email);
        }

}
