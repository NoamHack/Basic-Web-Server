package com.example.basicwebserver.service;

import com.example.basicwebserver.dto.StudentDTO;
import com.example.basicwebserver.entity.Grade;
import com.example.basicwebserver.entity.Student;
import com.example.basicwebserver.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class studentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    // DTO to Entity
    public Student convertToEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());
        student.setClassNumber(studentDTO.getClassNumber());
        return student;
    }

    // Entity to DTO
    public StudentDTO convertToDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setClassNumber(student.getClassNumber());
        studentDTO.setGradeIds(student.getGrades().stream().map(Grade::getId).collect(Collectors.toList()));
        return studentDTO;
    }

    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOs = new ArrayList<>();
        for (Student student : students) {
            StudentDTO studentDTO = convertToDTO(student);
            studentDTOs.add(studentDTO);
        }
        return studentDTOs;
    }

    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        return convertToDTO(student);
    }

    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = convertToEntity(studentDTO);
        studentRepository.save(student);
        return studentDTO;
    }

    public void deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        List<Grade> grades = student.getGrades();
        grades.forEach(grade -> grade.setStudent(null)); // Update the many side
        studentRepository.delete(student);
    }
}
