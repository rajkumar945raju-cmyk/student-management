package com.kiet.student.service;

import com.kiet.student.model.Student;
import com.kiet.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

  @Autowired
  StudentRepository studentRepository;

   public List<Student> getStudents(){
       List<Student> studentList=studentRepository.findAll();
       return studentList;
   }
   public Student getStudentById(int id){

       return studentRepository.findAll().stream()
               .filter(s -> s.getStudentId() == id)
               .findFirst()
               .orElseThrow(() -> new ResponseStatusException(
                       HttpStatus.NOT_FOUND,
                       "Student ID not found: " + id
               ));
   }
   public Student addStudent(Student student){
       return studentRepository.save(student);
   }

    public Student updateStudent(int id, Student student) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Student ID not found: " + id
                ));

        existingStudent.setName(student.getName());
        existingStudent.setBranch(student.getBranch());
        existingStudent.setCgpa(student.getCgpa());

        return studentRepository.save(existingStudent);
    }
   public boolean deleteStudent(int id){
       Optional<Student> student = studentRepository.findById(id);

       if (student.isPresent()) {
           studentRepository.delete(student.get());
           return true;
       }
       return false;
   }
    public List<Student> searchByBranchAndYear(
            String branch, String year) {

        return studentRepository.findByBranchAndYear(branch, year);
    }
    public List<Student> searchByCgpa(double cgpa) {
        return studentRepository.findByCgpa(cgpa);
    }

    public List<Student> searchByMinimumCgpa(double cgpa) {
        return studentRepository.findByCgpaGreaterThanEqual(cgpa);
    }

}
