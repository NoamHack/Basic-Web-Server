package com.example.basicwebserver.controller;


import com.example.basicwebserver.dto.StudentDTO;
import com.example.basicwebserver.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentServiceImpl;

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
}
