package com.kiet.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.DataAmount;
import lombok.Data;
@Entity
@Data
@Table()
public class Student {
    @Id
    private int id;

    private String name;
    private String email;
    private String course;
    private String year;
    private double cgpa;

}
