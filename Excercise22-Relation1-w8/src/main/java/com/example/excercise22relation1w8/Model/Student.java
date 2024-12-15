package com.example.excercise22relation1w8.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name not valid")
    @Column(columnDefinition = "varchar(35) not null")
    @Size(max = 35,message = "name length must be less then 35")
    private String name;

    @Positive(message = "age not valid")
    @Column(columnDefinition = "int not null")
    private Integer age;

    @NotEmpty(message = "major not valid")
    @Column(columnDefinition = "varchar(20) not null")
    @Size(max = 35,message = "major length must be less then 20")
    private String major;

    @ManyToMany
    @JsonIgnore
    private Set<Course> courses;
}
