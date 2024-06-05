package com.example.firstproject.controller;

import com.example.firstproject.dto.GradeDTO;
import com.example.firstproject.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/grades")
public class GradeController {
    private final GradeService gradeServiceImpl;

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
}
