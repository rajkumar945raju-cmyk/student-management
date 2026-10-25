package com.kiet.api.controller;

import com.kiet.api.model.Student;
import com.kiet.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    // 2. Get student by ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);

    }

    // 3. Add a new student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {

        return studentService.addStudent(student);
    }

    // 4. Update student by ID using PUT
    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable int id,
            @RequestBody Student updatedStudent) {

        return studentService.updateStudent(id,updatedStudent);
    }

    // 5. Delete student by ID
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        boolean removed = studentService.deleteStudent(id);

        if (removed) {
            return "Student with ID " + id + " deleted successfully";
        }else {
            return  "Student not found with ID: " + id;
        }

    }
}
