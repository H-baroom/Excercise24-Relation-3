package com.example.excercise22relation1w8.Repository;

import com.example.excercise22relation1w8.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findCourseById(Integer id);
}
