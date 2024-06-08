package com.example.basicwebserver.controller;


import com.example.basicwebserver.dto.StudentDTO;
import com.example.basicwebserver.service.StudentService;
import com.example.basicwebserver.service.gradeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentServiceImpl;
    private final gradeServiceImpl gradeServiceImpl;

    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentServiceImpl.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable Long id) {
        return studentServiceImpl.getStudentById(id);
    }

    @PostMapping
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) {
        return studentServiceImpl.createStudent(studentDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentServiceImpl.deleteStudent(id);
    }

    @GetMapping("/highest/{subject}")
    public StudentDTO getStudentWithHighestGradeInSubject(@PathVariable String subject) {
        return gradeServiceImpl.getStudentWithHighestGradeInSubject(subject);
    }
}
