package com.hrechana.educationSystem.repositories;

import com.hrechana.educationSystem.entity.University;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UniversityDAOImpl implements UniversityDAO {
    private static final String GET_ALL_UNIVERSITY_QUERY = "FROM University";

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public University getById(Long id) {
        return entityManager.find(University.class, id);
    }

    @Transactional
    @Override
    public University create(University university) {
        entityManager.persist(university);
        return getById(university.getId());
    }

    @Transactional
    @Override
    public University update(University university) {
        University univ = getById(university.getId());
        univ.setName(university.getName());
        univ.setCountry(university.getCountry());
        univ.setStudents(university.getStudents());
        entityManager.flush();
        return getById(university.getId());
    }

    @Transactional
    @Override
    public Long deleteById(Long id) {
        entityManager.remove(getById(id));
        return id;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<University> getAll() {
        return (List<University>) entityManager.createQuery(GET_ALL_UNIVERSITY_QUERY).getResultList();
    }
}
