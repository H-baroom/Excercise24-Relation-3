package com.example.excercise22relation1w8.Controller;

import com.example.excercise22relation1w8.Api.ApiResponse;
import com.example.excercise22relation1w8.Model.Student;
import com.example.excercise22relation1w8.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getAllStudents() {
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @RequestBody @Valid Student student) {
        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body(new ApiResponse("Student updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body(new ApiResponse("Student deleted"));
    }

    @PostMapping("/assignStudentToCourse/{student_id}/{course_id}")
    public ResponseEntity assignStudentToCourse(@PathVariable Integer student_id,@PathVariable Integer course_id){
        studentService.assignStudentToCourse(student_id, course_id);
        return ResponseEntity.status(200).body(new ApiResponse("Student assigned"));
    }

    @PutMapping("/changeMajor/{student_id}/{major}")
    public ResponseEntity changeMajor(@PathVariable Integer student_id,@PathVariable String major){
        studentService.changeMajor(student_id, major);
        return ResponseEntity.status(200).body(new ApiResponse("Student Major changed"));
    }



}
