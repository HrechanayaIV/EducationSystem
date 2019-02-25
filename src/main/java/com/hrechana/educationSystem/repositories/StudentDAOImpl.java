package com.hrechana.educationSystem.repositories;

import com.hrechana.educationSystem.entity.Student;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private static final String GET_ALL_QUERY = "FROM Student";

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public Student getById(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Transactional
    @Override
    public Student create(Student student) {
        entityManager.persist(student);
        return getById(student.getId());
    }

    @Transactional
    @Override
    public Student update(Student student) {
        Student std = getById(student.getId());
        std.setNameView(student.getNameView());
        std.setSpecialization(student.getSpecialization());
        std.setUniversity(student.getUniversity());
        entityManager.flush();
        return getById(student.getId());
    }

    @Transactional
    @Override
    public Long deleteById(Long id) {
        Student student = getById(id);
        entityManager.remove(student);
        return id;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Student> getAll() {
        return (List<Student>) entityManager.createQuery(GET_ALL_QUERY).getResultList();
    }
}
