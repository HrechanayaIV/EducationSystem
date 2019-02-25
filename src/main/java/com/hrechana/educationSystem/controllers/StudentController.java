package com.hrechana.educationSystem.controllers;

import com.hrechana.educationSystem.entity.Student;
import com.hrechana.educationSystem.services.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
        Student student = studentService.getById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> students = studentService.getAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/student")
    public ResponseEntity<Student> createStudent (@RequestBody Student student) {
        Student createdStudent = studentService.create(student);
        return new ResponseEntity<>(createdStudent,HttpStatus.CREATED);
    }

    @PutMapping("/student")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student updatedStudent = studentService.update(student);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
