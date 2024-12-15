package com.example.excercise22relation1w8.Controller;

import com.example.excercise22relation1w8.Api.ApiResponse;
import com.example.excercise22relation1w8.Model.Course;
import com.example.excercise22relation1w8.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getAllCourses() {
        return ResponseEntity.status(200).body(courseService.getAllCourses());
    }

    @PostMapping("/add/{teacher_id}")
    public ResponseEntity addCourse(@PathVariable Integer teacher_id, @RequestBody @Valid Course course) {
        courseService.addCourse(teacher_id, course);
        return ResponseEntity.status(200).body(new ApiResponse("Course added"));
    }

    @PutMapping("/update/{teacher_id}")
    public ResponseEntity updateCourse(@PathVariable Integer teacher_id, @RequestBody @Valid Course course) {
        courseService.updateCourse(teacher_id, course);
        return ResponseEntity.status(200).body(new ApiResponse("Course updated"));
    }

    @DeleteMapping("/delete/{course_id}")
    public ResponseEntity deleteCourse(@PathVariable Integer course_id) {
        courseService.deleteCourse(course_id);
        return ResponseEntity.status(200).body(new ApiResponse("Course deleted"));
    }

    @GetMapping("/teacherNameByCourse/{course_id}")
    public ResponseEntity teacherNameByCourse(@PathVariable Integer course_id) {
        String teacherName = courseService.teacherNameByCourse(course_id);
        return ResponseEntity.status(200).body(teacherName);
    }

    @GetMapping("/getAllStudentByCourseId/{course_id}")
    public ResponseEntity getAllStudentByCourseId(@PathVariable Integer course_id) {
        return ResponseEntity.status(200).body(courseService.getAllStudentByCourseId(course_id));
    }
}
