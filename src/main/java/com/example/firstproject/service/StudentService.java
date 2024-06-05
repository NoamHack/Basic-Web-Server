package com.example.firstproject.service;

import com.example.firstproject.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    public List<StudentDTO> getAllStudents(); // Get all students
    public StudentDTO getStudentById(Long id); // Get a student by id
    public StudentDTO createStudent(StudentDTO studentDTO); // Create a student
    public void deleteStudent(Long studentId); // Delete a student by id
}
