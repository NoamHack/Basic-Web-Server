package com.example.basicwebserver.repository;

import com.example.basicwebserver.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.id NOT IN (SELECT g.student.id FROM Grade g)")
    List<Student> findStudentsWithNoGrades();

    @Query("SELECT s FROM Student s JOIN s.grades g GROUP BY s.id HAVING AVG(g.grade) > :average")
    List<Student> findStudentsWithAverageAbove(Double average);
}
