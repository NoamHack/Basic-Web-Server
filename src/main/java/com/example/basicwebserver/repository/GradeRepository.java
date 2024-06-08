package com.example.basicwebserver.repository;

import com.example.basicwebserver.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    Grade findTopBySubjectOrderByGradeDesc(String subject);
}
