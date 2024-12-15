package com.example.excercise22relation1w8.DTO;

import com.example.excercise22relation1w8.Model.Student;
import com.example.excercise22relation1w8.Model.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class CourseOutDTO {

    private String name;

    private TeacherOutDTO teacherOutDTO;

    private Set<Student> students;

}
