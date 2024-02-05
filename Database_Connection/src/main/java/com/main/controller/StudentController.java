package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Student;
import com.main.service.StudentService;

@RestController
public class StudentController {
@Autowired
private StudentService studentservice;

@GetMapping("/{id}")
public Student get(@PathVariable Integer id) {
	return studentservice.getStudentId(id);
	
}
@GetMapping("/getall")
public List<Student> getall(){
	 return studentservice.getallStudents();
	
}

@PostMapping("/save")
public String add(@RequestBody Student student) {
	studentservice.saveStudent(student);
	return "all details saved successfully";
}

@PutMapping("/update/{id}")
public String update(@PathVariable Integer id,@RequestBody Student student) {
	studentservice.updateStudent(id, student);
	return "updated sucessfully";
	
}

@DeleteMapping("/delete/{id}")
public String delete(@PathVariable Integer id) {
	studentservice.deleteStudent(id);
	return "deleted successfully";
}
}
