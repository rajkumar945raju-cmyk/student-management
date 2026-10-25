package com.kiet.student;

import com.kiet.student.model.Student;
import com.kiet.student.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}



	@Bean
	CommandLineRunner loadStudentData(StudentRepository repository) {
		return args -> {

			System.out.println("KIET StudentManagement is starting...");
			System.out.println("Loading student data...");

			if (repository.count() == 0) {
				repository.save(new Student(
						1, "Raju ", "raju@gmail.com",
						"CSE", "2", 8.5
				));

				repository.save(new Student(
						2, "Aman Verma", "aman@gmail.com",
						"AI/ML", "2", 8.2
				));

				repository.save(new Student(
						3, "Priya Singh", "priya@gmail.com",
						"IT", "3", 9.1
				));
				repository.save(new Student(
						4, "Akash Verma", "akash@gmail.com",
						"IT", "3", 9.1
				));
				repository.save(new Student(
						5, "Vikas Singh", "vikas@gmail.com",
						"CSE", "4", 9.1
				));

				//System.out.println("Student data loaded successfully!");
			} else {
				//System.out.println("Student data already exists.");
			}


			System.out.println("Student Management REST API is Ready");
		};
	}


}
