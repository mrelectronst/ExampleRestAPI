package com.example.examplerestapi.infrastructure.service;

import com.example.examplerestapi.infrastructure.dto.StudentDto;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableAsync
public class StudentService {
    @Autowired
    StudentRepository repository;

    public List<StudentDto> getAllStudents() {
        return repository.findAll();
    }

    public List<StudentDto> getAllStudentsByFirstName(String firstName) {
        return repository.findStudentDtoByFirstName(firstName);
    }

    public String addStudent(StudentDto studentDto) {
        repository.save(studentDto);
        return "success";
    }

    public List<StudentDto> getAllStudentsByLastName(String lastName) {
        return repository.findStudentDtoByLastName(lastName);
    }

    public String deleteStudent(Integer id) {
        repository.deleteById(id);
        return "success";
    }

    public StudentDto updateStudent(Integer id, StudentDto studentDto) {
        var existingStudent = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Student: " + id));
        existingStudent.setFirstName(studentDto.firstName);
        existingStudent.setLastName(studentDto.lastName);
        repository.save(existingStudent);
        return existingStudent;
    }
}
