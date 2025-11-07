package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entity.Student;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
    CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return runner->{
			createStudent(studentDAO);
			//readStudent(studentDAO);
			//readAllStudent(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//studentDAO.deleteAll();
			readAllStudent(studentDAO);
		};
		
	}

	private void updateStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		int roll = 1;
		System.out.println("Getting student with id" + roll);
		Student stu = studentDAO.findById(roll);
		
		stu.setFirstname("Rushika");
		
		studentDAO.update(stu);
		
		readAllStudent(studentDAO);
		
	}

	private void deleteStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		int roll = 2;
		studentDAO.delete(roll);
		
		readAllStudent(studentDAO);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		List<Student> stu = studentDAO.findByLastName("Bakade");
		
		for(Student s : stu)
		{
			System.out.println(s);
		}
	}

	private void readAllStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		List<Student> theStudents = studentDAO.findAll();
		
		for(Student stu : theStudents)
		{
			System.out.println(stu);
		}
		
	}

	private void readStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		Student stu = new Student("zumba", "salsa", "salsaZumba@gamil.com");
		
		studentDAO.save(stu);
		
		int id = stu.getId();
		Student myStudent = studentDAO.findById(id);
		
		System.out.println(myStudent +" "+ id);
	}

	private void createStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		//create student obj
		Student stu = new Student("Amruta", "Bakade", "Amruta@gamil.com");
		
		//save obj
		studentDAO.save(stu);
	}
}
