package com.example.hw22.DTO;

import com.example.hw22.Model.Teacher;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    private Integer teacher_id;
    private String area;
    private String street;
    private Integer buildingNumber;
    private Teacher teacher;

}
