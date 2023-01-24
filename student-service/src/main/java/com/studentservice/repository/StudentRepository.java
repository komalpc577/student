package com.studentservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.studentservice.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

	public Student findBystudentNameAndPassword(String studentName, String password);

	// @Query(value = "SELECT * FROM student WHERE studentName = ?", nativeQuery = true)
	   // Student findStudentBystudentName(String studentName);

		public Student findStudentBystudentName(String studentName);

	    

}
