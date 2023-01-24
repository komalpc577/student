package com.studentservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.hibernate.mapping.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.studentservice.entity.Student;
import com.studentservice.repository.StudentRepository;

@SpringBootTest
class StudentServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private StudentRepository repository;
	
	@Test
	public void getAllRemitterTest() {
		java.util.List<Student> l = repository.findAll();
		assertThat(l).size().isGreaterThan(0);
	}
	
	@Test
	public void findByIdTest() {
		Optional<Student> u = repository.findById(4);
//		assertEquals("Shubham", u.getStudentName());
	}
	

}
