package com.hrechana.educationSystem.repositories;

import com.hrechana.educationSystem.EducationSystemApplication;
import com.hrechana.educationSystem.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EducationSystemApplication.class)
public class StudentRepositoryTests {

    @Autowired
    private StudentDAOImpl studentRepository;

    @Test
    public void testGetById() throws Exception {
        Student student = studentRepository.getById(1L);
        assertThat(student.getId()).isEqualTo(1L);
        assertThat(student.getNameView()).isEqualTo("Inna Hrechana");
        assertThat(student.getSpecialization()).isEqualTo("Physics of Functional Materials");
    }

    @Test
    public void testGetAll() {
        Student student1 = new Student(1L,"Inna Hrechana", "Physics of Functional Materials");
        Student student2 = new Student(2L,"Viktor Zabolotnyi", "Telecommunication systems and networks");

        List<Student> testStudents = studentRepository.getAll();
        assertThat(testStudents.get(0)).isEqualTo(student1);
        assertThat(testStudents.get(1)).isEqualTo(student2);
    }

    @Test
    public void testCreate(){
        Student student = new Student("Name", "Specialization");
        Student createdStudent = studentRepository.create(student);
        Student student1 = new Student(4L,"Name", "Specialization");
        assertThat(createdStudent).isEqualTo(student1);
    }

    @Test
    public void testUpdate(){
        Student student = new Student(3L,"Name", "Specialization");
        Student updatedStudent = studentRepository.update(student);
        assertThat(updatedStudent).isEqualTo(student);
    }


    @Test
    public void testDeleteById() {
        Long id = 3L;
        Long deletedStudentId = studentRepository.deleteById(3L);
        assertThat(deletedStudentId).isEqualTo(id);
    }

}

