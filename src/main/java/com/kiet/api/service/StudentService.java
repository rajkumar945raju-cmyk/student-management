package com.kiet.api.service;

import com.kiet.api.model.Student;
import com.kiet.api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
               .filter(s -> s.getId() == id)
               .findFirst()
               .orElse(null);
   }
   public Student addStudent(Student student){
       return studentRepository.save(student);
   }

   public Student updateStudent(int id ,Student student){

       Optional<Student> savedStudent=studentRepository.findById(id);
       if (savedStudent.isPresent()) {
           savedStudent.get().setName(student.getName());
           savedStudent.get().setCourse(student.getCourse());

           studentRepository.save(savedStudent.get());
       }else {
           throw new org.springframework.web.server.ResponseStatusException(
                   org.springframework.http.HttpStatus.NOT_FOUND,
                   "Student not found with ID: " + id
           );
       }
       return savedStudent.get();
   }

   public boolean deleteStudent(int id){
       Optional<Student> student = studentRepository.findById(id);

       if (student.isPresent()) {
           studentRepository.delete(student.get());
           return true;
       }
       return false;
   }
}
