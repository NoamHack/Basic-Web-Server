package com.example.basicwebserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Grade extends BaseEntity{
    private int grade;
    private String subject;

    @ManyToOne
    @JoinColumn(nullable = false, name = "student_id",
    foreignKey = @ForeignKey(name = "fk_grade_student"))
    private Student student;
}
