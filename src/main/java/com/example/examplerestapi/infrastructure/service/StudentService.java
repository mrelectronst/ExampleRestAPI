package com.example.examplerestapi.infrastructure.service;

import com.example.examplerestapi.infrastructure.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;

    public List<StudentDto> getAllStudents() {
        var students = repository.findAll();
        return students;
    }

    public List<StudentDto> getAllStudentsByFirstName(String firstName) {
        return repository.findStudentDtoByFirstName(firstName);
    }

    public String addStudent(StudentDto studentDto) {
        var student = new StudentDto();
        student.setId(studentDto.id);
        student.setFirstName(studentDto.firstName);
        student.setLastName(studentDto.lastName);

        repository.save(student);
        return "success";
    }

    public List<StudentDto> getAllStudentsByLastName(String lastName) {
        return repository.findStudentDtoByLastName(lastName);
    }
}
