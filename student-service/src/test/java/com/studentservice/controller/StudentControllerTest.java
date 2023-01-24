package com.studentservice.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.studentservice.entity.Student;
import com.studentservice.repository.StudentRepository;
import com.studentservice.service.StudentService;
@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
	@InjectMocks
	private StudentService service;
	
	@Mock
	private StudentRepository repository;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	public void createStudentrTest() {
		Student registration = new Student(1, "shivknyakaka", "pune", "2345567", "NACSCS", "shiv@gmail.com", "shiv@123");
		Mockito.when(repository.save(registration)).thenReturn(registration);
		Student rg = service.registers(registration);
		assertEquals(registration, rg);
	}
	
	@Test
	public void readAllStudentTest() {
		Student registration = new Student(4, "sonali", "Latur","903456", "NACSCS", "soni@gmail.com", "sona@12");
		List<Student> list = new ArrayList<>();
		list.add(registration);
		Mockito.when(repository.findAll()).thenReturn(list);
		List<Student> actual =  service.getAllStudent();
		assertEquals(list, actual);
		assertEquals(list.size(), actual.size());
		assertEquals(list.get(0), actual.get(0));
	}
	
	

}
