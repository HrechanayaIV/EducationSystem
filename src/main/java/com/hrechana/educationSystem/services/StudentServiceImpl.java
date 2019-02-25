package com.hrechana.educationSystem.services;

import com.hrechana.educationSystem.entity.Student;
import com.hrechana.educationSystem.repositories.StudentDAOIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentDAOIml studentRepository;

    @Override
    public Student getById(Long id) {
        return studentRepository.getById(id);
    }

    @Override
    public Student create(Student student) {
        return studentRepository.create(student);
    }

    @Override
    public Student update(Student student) {
        return studentRepository.update(student);
    }

    @Override
    public Long deleteById(Long id) {
        return studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }
}
