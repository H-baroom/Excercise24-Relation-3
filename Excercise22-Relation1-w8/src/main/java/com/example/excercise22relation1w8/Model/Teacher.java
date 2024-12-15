package com.example.excercise22relation1w8.Model;
import com.example.excercise22relation1w8.Model.Course;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(25) not null")
    @NotEmpty(message = "name not valid")
    @Size(max = 25)
    private String name;

    @Column(columnDefinition = "int not null")
    @Positive(message = "age not valid")
    @Min(value = 18)
    private Integer age;

    @NotEmpty(message = "email not valid")
    @Email(message = "email not valid")
    @Column(columnDefinition = "varchar(40) not null")
    @Size(max = 40)
    private String email;

    @Column(columnDefinition = "int not null")
    @Positive(message = "salary not valid")
    private Integer salary;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Set<Course> courses;

}
