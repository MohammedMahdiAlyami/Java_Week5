package com.example.hw23.DTO;

import com.example.hw23.Model.Teacher;
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
