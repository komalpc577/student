package com.studentservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import com.studentservice.entity.Student;
import com.studentservice.exception.IdNotFound;
import com.studentservice.exception.NameNotFoundException;
import com.studentservice.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentrepository;
	public Student registers(Student student) {
		// TODO Auto-generated method stub
		return studentrepository.save(student);
	}
	
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentrepository.findAll();
	}

	public Optional<Student> getAllStudentById(int id) {
		// TODO Auto-generated method stub
		return studentrepository.findById(id);
	}

	public Student fetchStudentBystudentName(String studentName, String password) {
		// TODO Auto-generated method stub
		return studentrepository.findBystudentNameAndPassword(studentName,password);
	}
	
	public String update(int id, Student student) {
		// TODO Auto-generated method stub
		if(studentrepository.existsById(id)) {
			student.setId(id);
			 studentrepository.save(student);
			 return "Record update";
		}else {
			studentrepository.save(student);
			
		}
		return "record update";
	}

	public int deleteById(int id) throws IdNotFound {
		if(studentrepository.existsById(id)) {
		 studentrepository.deleteById(id);
		 return 1;
		}
		else {
			
			throw new IdNotFound("Id not found with id "+id+" please enter valid Id");
		}
	}

	public Student getAllStudentBystudentName(String studentName) throws NameNotFoundException{
		 Student student = studentrepository.findStudentBystudentName(studentName);
//		    if (student.isPresent()) {
//		        return student.get();
//		    }
//		    else {
//		    	throw new NameNotFoundException("record not found with this Name: " + studentName);
//		    }
		return student;
	}
	

}
