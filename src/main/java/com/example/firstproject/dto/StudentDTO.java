package com.example.firstproject.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentDTO {
    private Long id;
    private String name;
    private int classNumber;
    private List<Long> gradeIds;
}
