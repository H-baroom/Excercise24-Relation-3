package com.example.excercise22relation1w8.Repository;

import com.example.excercise22relation1w8.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findTeacherById(Integer id);


}
