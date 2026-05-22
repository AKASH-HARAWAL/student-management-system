package com.akash.studentmanagement.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akash.studentmanagement.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	List<Student> findByDepartment(String department);
	
	List<Student> findByName(String name);
	
	List<Student> findByCgpaGreaterThan(double cgpa);

}