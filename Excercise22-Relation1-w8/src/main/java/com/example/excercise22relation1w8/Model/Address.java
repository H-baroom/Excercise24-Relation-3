package com.example.excercise22relation1w8.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    private Integer id;

    @Column(columnDefinition = "varchar(40) not null")
    @NotEmpty(message = "area not valid")
    @Size(max = 30)
    private String area;

    @Column(columnDefinition = "varchar(30) not null")
    @NotEmpty(message = "street not valid")
    @Size(max = 30)
    private String street;

    @Column(columnDefinition = "int not null ")
    @Positive(message = "Building Number not valid")
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;

}
