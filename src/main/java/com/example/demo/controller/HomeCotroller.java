package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@RestController
public class HomeCotroller {
	@Autowired
	private StudentRepository studentRepository;

	//handler to add new student record in db
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		studentRepository.save(student);
		return student;
	}
	
	//handler to get all students records from db
	@GetMapping("/getAllStudents")
	public List<Student> getAll(){
		List<Student> studentList = studentRepository.findAll();
		return studentList;
	}
	
	//handler to delete a student record by rollNo from db
	@DeleteMapping("/deleteSudent/{rollNo}")
	public String deleteStudent(@PathVariable int rollNo) {
		Student student=studentRepository.findById(rollNo).get();
		if(student!=null)
			studentRepository.delete(student);
		return "student record deleted successfully";
	}
	//handler to update a student record in db
	@PutMapping("/updateStudent")
	public Student updateStudentData(@RequestBody Student student) {
		studentRepository.save(student);
		return student;
		
	}
	
	}
