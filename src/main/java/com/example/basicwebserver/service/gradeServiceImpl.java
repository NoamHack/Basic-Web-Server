package com.example.basicwebserver.service;

import com.example.basicwebserver.dto.GradeDTO;
import com.example.basicwebserver.entity.Grade;
import com.example.basicwebserver.entity.Student;
import com.example.basicwebserver.repository.GradeRepository;
import com.example.basicwebserver.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class gradeServiceImpl implements GradeService {
    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;

    // DTO to Entity
    public Grade convertToEntity(GradeDTO gradeDTO) {
        Grade grade = new Grade();
        grade.setId(gradeDTO.getId());
        grade.setGrade(gradeDTO.getGrade());
        grade.setSubject(gradeDTO.getSubject());
        return grade;
    }

    // Entity to DTO
    public GradeDTO convertToDTO(Grade grade) {
        GradeDTO gradeDTO = new GradeDTO();
        gradeDTO.setId(grade.getId());
        gradeDTO.setGrade(grade.getGrade());
        gradeDTO.setSubject(grade.getSubject());
        if (grade.getStudent() != null) {
            gradeDTO.setStudentId(grade.getStudent().getId());
        }
        return gradeDTO;
    }

    public List<GradeDTO> getAllGrades() {
        List<Grade> grades = gradeRepository.findAll();
        List<GradeDTO> gradeDTOs = new ArrayList<>();
        for (Grade grade : grades) {
            GradeDTO gradeDTO = convertToDTO(grade);
            gradeDTOs.add(gradeDTO);
        }
        return gradeDTOs;
    }

    public GradeDTO getGradeById(Long id) {
        Grade grade =  gradeRepository.findById(id).orElse(null);
        return convertToDTO(grade);
    }

    public GradeDTO createGrade(GradeDTO gradeDTO) {
        Grade grade = convertToEntity(gradeDTO);

        // Retrieve the Student entity based on the studentId from the GradeDTO
        Student student = studentRepository.findById(gradeDTO.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID"));

        grade.setStudent(student);
        gradeRepository.save(grade);
        return gradeDTO;
    }


    public void deleteGrade(Long gradeId) {
        Grade grade = gradeRepository.findById(gradeId).orElse(null);
        Student student = grade.getStudent();
        student.getGrades().remove(grade); // Update the one side
        gradeRepository.delete(grade);
    }

}
