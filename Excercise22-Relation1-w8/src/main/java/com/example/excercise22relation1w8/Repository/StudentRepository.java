package com.example.excercise22relation1w8.Repository;

import com.example.excercise22relation1w8.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findStudentById(Integer id);
}
