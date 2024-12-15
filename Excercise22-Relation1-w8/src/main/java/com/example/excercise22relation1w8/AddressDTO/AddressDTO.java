package com.example.excercise22relation1w8.AddressDTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@AllArgsConstructor
@Data
public class AddressDTO {

    private Integer teacher_id;

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
}
