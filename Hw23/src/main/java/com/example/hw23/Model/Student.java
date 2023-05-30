package com.example.hw23.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Student name must be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotNull(message ="Student age must be not empty" )
    @Positive(message = "Enter positive number")
    @Column(columnDefinition = "Int not null")
    private Integer age;

    @NotEmpty(message = "Major must be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String major;



    @ManyToMany(mappedBy = "student")
    private Set<Course> courses;

}
