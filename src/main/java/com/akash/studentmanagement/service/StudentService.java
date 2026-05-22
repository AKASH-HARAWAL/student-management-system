package com.akash.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.studentmanagement.model.Student;
import com.akash.studentmanagement.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    
    }

    public Student updateStudent(int id, Student updatedStudent) {

    	Student student = studentRepository.findById(id)
    	        .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

         {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setDepartment(updatedStudent.getDepartment());
            student.setCgpa(updatedStudent.getCgpa());

            return studentRepository.save(student);
        }

        
    }

    public String deleteStudent(int id) {
        studentRepository.deleteById(id);
        return "Student Deleted Successfully";
    }
    
    public List<Student> getStudentsByDepartment(String department) {
        return studentRepository.findByDepartment(department);
    }
    
    public List<Student> getStudentsByName(String name) {
        return studentRepository.findByName(name);
    }
    
    public List<Student> getStudentsByCgpaGreaterThan(double cgpa) {
        return studentRepository.findByCgpaGreaterThan(cgpa);
    }
    
    public long countStudents() {
        return studentRepository.count();
    }
    
    public String deleteAllStudents() {
        studentRepository.deleteAll();
        return "All Students Deleted Successfully";
    }
}