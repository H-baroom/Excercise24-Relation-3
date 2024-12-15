package com.example.excercise22relation1w8.DTO;

import com.example.excercise22relation1w8.Model.Address;
import com.example.excercise22relation1w8.Model.Course;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;
@Data
@AllArgsConstructor
public class TeacherOutDTO {

    private String name;

    private String email;

    private AddressOutDTO addressOutDTO;

}
