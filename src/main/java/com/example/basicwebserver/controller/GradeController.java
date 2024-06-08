package com.example.basicwebserver.controller;

import com.example.basicwebserver.dto.GradeDTO;
import com.example.basicwebserver.dto.StudentDTO;
import com.example.basicwebserver.service.GradeService;
import com.example.basicwebserver.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/grades")
public class GradeController {
    private final GradeService gradeServiceImpl;
    private final StudentService studentServiceImpl;

    @GetMapping
    public List<GradeDTO> getAllGrades() {
        return gradeServiceImpl.getAllGrades();
    }

    @GetMapping("/{id}")
    public GradeDTO getGradeById(@PathVariable Long id) {
        return gradeServiceImpl.getGradeById(id);
    }

    @PostMapping
    public GradeDTO createGrade(@RequestBody GradeDTO gradeDTO) {
        return gradeServiceImpl.createGrade(gradeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteGrade(@PathVariable Long id) {
        gradeServiceImpl.deleteGrade(id);
    }

    @GetMapping("/average-above/{average}")
    public List<StudentDTO> getStudentsWithAverageAbove(@PathVariable Double average) {
        return studentServiceImpl.getStudentsWithAverageAbove(average);
    }

    @GetMapping("/no-grades")
    public List<StudentDTO> getStudentsWithNoGrades() {
        return studentServiceImpl.getStudentsWithNoGrades();
    }
}
