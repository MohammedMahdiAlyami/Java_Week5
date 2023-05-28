package com.example.hw21.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name must be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotNull(message ="age must be not null" )
    @Column(columnDefinition = "int must be not null unique")
    private Integer age;

    @NotEmpty(message = "Teacher email must be not empty")
    @Email(message = "Enter valid email")
    @Column(columnDefinition = "varchar(20) not null")
    private String email;

    @NotNull(message ="Teacher salary must be not double" )
    @Column(columnDefinition = "int must be not null")
    private double salary;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

}
