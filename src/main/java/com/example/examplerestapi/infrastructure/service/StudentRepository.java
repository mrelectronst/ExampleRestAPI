package com.example.examplerestapi.infrastructure.service;

import com.example.examplerestapi.infrastructure.dto.StudentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentDto, Integer> {
    List<StudentDto> findStudentDtoByFirstName(String firstName);

    @Query(value = "select * from Test.students s where s.last_name =:lastName", nativeQuery = true)
    List<StudentDto> findStudentDtoByLastName(String lastName);
}
