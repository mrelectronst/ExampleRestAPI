package com.example.examplerestapi.infrastructure.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(schema = "Test", name = "students")
public class StudentDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;

    public StudentDto() {
    }
}
