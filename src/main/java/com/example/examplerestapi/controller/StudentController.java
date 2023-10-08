package com.example.examplerestapi.controller;

import com.example.examplerestapi.infrastructure.dto.StudentDto;
import com.example.examplerestapi.infrastructure.service.StudentService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("students")
    public ResponseEntity<List<StudentDto>> getAll() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("studentbyfirstname/{firstName}")
    public ResponseEntity<List<StudentDto>> getAllByFirstName(@PathVariable String firstName) {
        return new ResponseEntity<>(studentService.getAllStudentsByFirstName(firstName), HttpStatus.OK);
    }

    @GetMapping("studentbylastname/{lastName}")
    public ResponseEntity<List<StudentDto>> getAllByLastName(@PathVariable String lastName) {
        return new ResponseEntity<>(studentService.getAllStudentsByLastName(lastName), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<String> createStudent(@RequestParam Integer id, @RequestParam String firstName, @RequestParam String lastName) {
        return new ResponseEntity<>(studentService.addStudent(new StudentDto(id, firstName, lastName)), HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<String> addStudent(@RequestBody StudentDto studentDto) {
        return new ResponseEntity<>(studentService.addStudent(studentDto), HttpStatus.OK);
    }
}
