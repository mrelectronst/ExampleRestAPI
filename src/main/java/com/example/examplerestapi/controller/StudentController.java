package com.example.examplerestapi.controller;

import com.example.examplerestapi.infrastructure.dto.StudentDto;
import com.example.examplerestapi.infrastructure.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("students")
    @Async
    public CompletableFuture<ResponseEntity<List<StudentDto>>> getAll() {
        return CompletableFuture.supplyAsync(() -> new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK));
    }

    @GetMapping("studentbyfirstname/{firstName}")
    @Async
    public CompletableFuture<ResponseEntity<List<StudentDto>>> getAllByFirstNameAsync(@PathVariable String firstName) {
        return CompletableFuture.supplyAsync(() -> new ResponseEntity<>(studentService.getAllStudentsByFirstName(firstName), HttpStatus.OK));
    }

    @GetMapping("studentbylastname/{lastName}")
    public CompletableFuture<ResponseEntity<List<StudentDto>>> getAllByLastName(@PathVariable String lastName) {
        return CompletableFuture.supplyAsync(() -> new ResponseEntity<>(studentService.getAllStudentsByLastName(lastName), HttpStatus.OK));
    }

    @PostMapping("/create")
    public CompletableFuture<ResponseEntity<String>> createStudent(@RequestBody StudentDto studentDto) {
        return CompletableFuture.supplyAsync(() -> new ResponseEntity<>(studentService.addStudent(studentDto), HttpStatus.OK));
    }

    @PutMapping("update/{id}")
    public CompletableFuture<ResponseEntity<StudentDto>> updateStudent(@PathVariable Integer id, @RequestBody StudentDto studentDto) {
        return CompletableFuture.supplyAsync(() -> new ResponseEntity<>(studentService.updateStudent(id, studentDto), HttpStatus.OK));
    }

    @DeleteMapping("delete/{id}")
    public CompletableFuture<ResponseEntity<String>> deleteStudent(@PathVariable Integer id) {
        return CompletableFuture.supplyAsync(() -> new ResponseEntity<>(studentService.deleteStudent(id), HttpStatus.OK));
    }
}
