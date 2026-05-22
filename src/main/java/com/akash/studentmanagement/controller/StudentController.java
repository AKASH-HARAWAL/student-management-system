package com.akash.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.akash.studentmanagement.model.Student;
import com.akash.studentmanagement.service.StudentService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/test")
    public String test() {
        return "Student Management System Running Successfully";
    }

    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id,
    		@Valid @RequestBody Student updatedStudent) {

        return studentService.updateStudent(id, updatedStudent);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        return studentService.deleteStudent(id);
    }
    
    @GetMapping("/department/{department}")
    public List<Student> getStudentsByDepartment(@PathVariable String department) {

        return studentService.getStudentsByDepartment(department);
    }
    
    @GetMapping("/name/{name}")
    public List<Student> getStudentsByName(@PathVariable String name) {

        return studentService.getStudentsByName(name);
    }
    
    @GetMapping("/cgpa/{cgpa}")
    public List<Student> getStudentsByCgpaGreaterThan(@PathVariable double cgpa) {

        return studentService.getStudentsByCgpaGreaterThan(cgpa);
    }
    
    @GetMapping("/count")
    public long countStudents() {
        return studentService.countStudents();
    }
    
    @DeleteMapping("/deleteAll")
    public String deleteAllStudents() {

        return studentService.deleteAllStudents();
    }
    
    @GetMapping("/")
    public String home() {

        return """
                Student Management System APIs:

                GET    /students
                GET    /students/{id}
                POST   /students
                PUT    /students/{id}
                DELETE /students/{id}

                GET    /students/department/{department}
                GET    /students/name/{name}
                GET    /students/cgpa/{cgpa}
                GET    /students/count

                DELETE /students/deleteAll
                """;
    }
}