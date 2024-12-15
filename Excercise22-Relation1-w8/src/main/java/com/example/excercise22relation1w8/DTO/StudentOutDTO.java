package com.example.excercise22relation1w8.DTO;

import com.example.excercise22relation1w8.Model.Course;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class StudentOutDTO {

    private String name;

    private String major;

    private List<CoursesStudentsOutDTO> courses;
}
