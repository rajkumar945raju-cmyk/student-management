package com.kiet.student.repository;

import com.kiet.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository
        extends JpaRepository<Student, Integer> {
    List<Student> findByBranchAndYear(String branch, String year);

    List<Student> findByCgpa(double cgpa);

    List<Student> findByCgpaGreaterThanEqual(double cgpa);
}