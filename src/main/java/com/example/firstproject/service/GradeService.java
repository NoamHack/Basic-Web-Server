package com.example.firstproject.service;

import com.example.firstproject.dto.GradeDTO;

import java.util.List;

public interface GradeService {
    public List<GradeDTO> getAllGrades(); // Get all grades
    public GradeDTO getGradeById(Long id); // Get a grade by id
    public GradeDTO createGrade(GradeDTO gradeDTO); // Create a grade
    public void deleteGrade(Long gradeId); // Delete a grade by id
}
