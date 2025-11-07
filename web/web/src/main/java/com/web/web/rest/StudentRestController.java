package com.web.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.web.entity.Student;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	List<Student> theStudents;
	
	@PostConstruct
	public void load()
	{
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Amruta", "Bakade"));
		theStudents.add(new Student("ekta", "PK"));
		theStudents.add(new Student("zumba", "salsa"));
	}
	@GetMapping("/students")
	public List<Student> getStudents()
	{
		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId)
	{
		return theStudents.get(studentId);
	}
}
