package com.kiet.student.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
@Entity
@Data
@AllArgsConstructor
@Table()
public class Student {
    @Id
    private int studentId;

    private String name;
    private String email;
    private String branch;

    @Column(name = "student_year")
    private String year;
    private double cgpa;

    public Student() {

    }
}
