package com.example.hw23.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Teacher name must be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotNull(message ="Teacher age must be not empty" )
    @Positive(message = "Enter positive number")
    @Column(columnDefinition = "Int not null")
    private Integer age;

    @NotEmpty(message = "Email must be not empty")
    @Email(message = "Enter valid email")
    @Column(columnDefinition = "varchar(20) not null")
    private String email;

    @NotNull(message ="Teacher salary must be not empty" )
    @Positive(message = "Enter positive number")
    @Column(columnDefinition = "double not null")
    private double salary;




    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private Set<Course> courseSet;

}

