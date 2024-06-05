package com.example.basicwebserver.repository;

import com.example.basicwebserver.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
