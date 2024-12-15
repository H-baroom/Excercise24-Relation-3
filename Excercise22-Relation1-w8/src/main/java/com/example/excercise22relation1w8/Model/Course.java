package com.example.excercise22relation1w8.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(25) not null")
    @NotEmpty(message = "name not valid")
    @Size(max=25)
    private String name;

    @ManyToOne
    @JsonIgnore
    private Teacher teacher;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;
}
