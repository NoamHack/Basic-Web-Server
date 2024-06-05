package com.example.firstproject.controller;


import com.example.firstproject.dto.StudentDTO;
import com.example.firstproject.entity.Student;
import com.example.firstproject.service.StudentService;
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
