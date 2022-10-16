package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // We want to have a custom function where we find user by email
    // Multiple ways to do this
    // Construct the query based on method name

    // This transforms to SQL such as:
    // SELECT * FROM student WHERE email = ?
    // So we can have this
    // Optional<Student> findStudentByEmail(String email)

    // or we can be more specific and state the query being run with
    // the annotation @Query like so:
    // this is JPQL and not SQL
    @Query("SELECT s FROM Student s where s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

}
