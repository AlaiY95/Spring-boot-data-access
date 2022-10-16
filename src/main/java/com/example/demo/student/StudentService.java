package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

// @Service can also be @Component but @Service is preferred for semantics
@Service

public class StudentService {

    private final StudentRepository studentRepository;

    // StudentRepository is @Autowired
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    // addNewStudent method
    public void addNewStudent(Student student) {
        // If email from POST payload does not exist, then we save into database, otherwise, throw exception
        // Simple validation
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken.. soz bruh");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        studentRepository.findById(studentId);
                boolean exists = studentRepository.existsById(studentId);
                if (!exists) {
                    throw new IllegalStateException(("student with id " + studentId + " does not exist"));
                }
                studentRepository.deleteById(studentId);

    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException
                        "student with id " + studentId + " does not exist"
                );

    }

    public void updateStudent(Long studentId) {
        studentRepository.findById(studentId);
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException(("student with id " + studentId + " does not exist"));
        }
        studentRepository.updatebyId(studentId);

    }
}
