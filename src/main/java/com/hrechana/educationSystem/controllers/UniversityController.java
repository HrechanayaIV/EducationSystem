package com.hrechana.educationSystem.controllers;

import com.hrechana.educationSystem.entity.University;
import com.hrechana.educationSystem.services.UniversityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UniversityController {
    @Autowired
    private UniversityServiceImpl universityService;

    @GetMapping("/university/{id}")
    public ResponseEntity<University> getUniversityById(@PathVariable("id") Long id) {
        University university = universityService.getById(id);
        return new ResponseEntity<>(university, HttpStatus.OK);
    }

    @GetMapping("/universities")
    public ResponseEntity<List<University>> getAllUniversity() {
        List<University> universities = universityService.getAll();
        return new ResponseEntity<>(universities, HttpStatus.OK);
    }

    @PostMapping("/university")
    public ResponseEntity<University> createUniversity (@RequestBody University university) {
        University createdUniversity =universityService.create(university);
        return new ResponseEntity<>(createdUniversity,HttpStatus.CREATED);
    }

    @PutMapping("/university")
    public ResponseEntity<University> updateUniversity(@RequestBody University university) {
        University updatedUniversity = universityService.update(university);
        return new ResponseEntity<>(updatedUniversity, HttpStatus.OK);
    }

    @DeleteMapping("/university/{id}")
    public ResponseEntity<Void> deleteUniversity(@PathVariable("id") Long id) {
        universityService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
