package com.studentservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studentservice.entity.Student;
import com.studentservice.exception.IdNotFound;
import com.studentservice.exception.NameNotFoundException;
import com.studentservice.service.StudentService;


@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentservice;
	
	@PostMapping("/register")
	public Student registers(@RequestBody Student student ) {
		return studentservice.registers(student);
		
	}
	@PostMapping("/login")
	public Student loginstudent(@RequestBody Student student) throws Exception {
		String studentName=student.getStudentName();
		String password=student.getPassword();
		Student userObj=null;
		if(studentName!=null&& password!=null)
		{
			userObj=studentservice.fetchStudentBystudentName(studentName, password);
		}
		
		if(userObj==null)
		{
			throw new Exception("Bad credentials");
		}
		return userObj;
		
	}
	@GetMapping("/getallstudent")
	public List<Student> getAllStudent() {
		return studentservice.getAllStudent();
	}
	@GetMapping("/getallstudent/{id}")
	public Optional<Student> getAllStudentById(@PathVariable("id") int id) {
		return studentservice.getAllStudentById(id);
	}
	@GetMapping("/getall/{studentName}")
	public Student getAllStudentBystudentName(@PathVariable("studentName") String studentName) throws Exception  {
		Student user = null;
		if (studentName != null) {
		user= studentservice.getAllStudentBystudentName(studentName);
		System.out.println(studentName  + " Is available");
	}
		if(user == null) {
			System.out.println("Not available");
			throw new Exception(studentName +" Not Available");
		}
		return user;
	}
//	@PutMapping("/updatestudentBy{/id}")
//	public Student update(@PathVariable("id") int id,@RequestBody Student student) {
//		return studentservice.update(id,student);
//	}
	@PutMapping("/student/updateById/{id}")
	public String updateById(@PathVariable("id") int id, @RequestBody Student student) {
		return studentservice.update(id, student);
	}
	
	@DeleteMapping("/deleteBy/{id}")
	
	public int deleteById(@PathVariable("id") int id) throws IdNotFound {
		return studentservice.deleteById(id);
		
	}
	
	
}
