package com.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.Student;
import com.main.repo.StudentRepository;

@Service
public class StudentService {

@Autowired
private StudentRepository studentrepository;
//getmapping

public List<Student> getallStudents(){
	return studentrepository.findAll();
}

public Student getStudentId(Integer id){
	return studentrepository.findById(id).get();
}


//postmapping

public Student saveStudent(Student student) {
	return studentrepository.save(student);
}
 
//putmapping

public Student updateStudent(Integer id,Student stu) {
	Student updates=studentrepository.findById(id).orElse(null);
	updates.setName(stu.getName());
	updates.setAddress(stu.getAddress());
	updates.setPercentage(stu.getPercentage());
	return studentrepository.save(updates);
}
//deletemapping
public void deleteStudent(Integer id) {
	studentrepository.deleteById(id);
}
}