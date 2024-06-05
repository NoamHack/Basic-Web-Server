package com.example.basicwebserver.dto;

import lombok.Data;

@Data
public class GradeDTO {
    private Long id;
    private int grade;
    private String subject;
    private Long studentId;
}
