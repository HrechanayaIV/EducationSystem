package com.hrechana.educationSystem.services;

import com.hrechana.educationSystem.entity.University;
import com.hrechana.educationSystem.repositories.UniversityDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService{
    @Autowired
    private UniversityDAOImpl universityRepository;

    @Override
    public University getById(Long id) {
        return universityRepository.getById(id);
    }

    @Override
    public University create(University university) {
        return universityRepository.create(university);
    }

    @Override
    public University update(University university) {
        return universityRepository.update(university);
    }

    @Override
    public Long deleteById(Long id) {
        return universityRepository.deleteById(id);
    }

    @Override
    public List<University> getAll() {
        return universityRepository.getAll();
    }
}
