package com.hrechana.educationSystem.services;

import com.hrechana.educationSystem.entity.Student;
import com.hrechana.educationSystem.repositories.StudentDAOIml;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTests {

    @MockBean
    private StudentDAOIml studentRepository;

    @Autowired
    private StudentServiceImpl studentService;


    @Test
    public void testGetById() {
        given(this.studentRepository.getById(any()))
                .willReturn(new Student(1L,"Test Name", "SpecializationTest"));
        Student student = studentService.getById(1L);
        assertThat(student.getId()).isEqualTo(1L);
        assertThat(student.getNameView()).isEqualTo("Test Name");
        assertThat(student.getSpecialization()).isEqualTo("SpecializationTest");
    }

    @Test
    public void testGetAll() {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student(1L,"name1", "Specialization1");
        Student student2 = new Student(2L,"name2", "Specialization2");
        students.add(student1);
        students.add(student2);
        given(this.studentRepository.getAll())
                .willReturn(students);
        List<Student> testStudents = studentService.getAll();
        assertThat(testStudents.get(0)).isEqualTo(student1);
        assertThat(testStudents.get(1)).isEqualTo(student2);
    }

    @Test
    public void testCreate(){
        Student student = new Student(1L,"name", "Specialization");
        given(this.studentRepository.create(any())).willReturn(student);
        Student createdStudent = studentService.create(student);
        assertThat(createdStudent).isEqualTo(student);
    }


    @Test
    public void testDeleteById() {
        Long id = 1L;
        given(this.studentRepository.deleteById(any())).willReturn(id);
        Long deletedStudentId = studentRepository.deleteById(1L);
        assertThat(deletedStudentId).isEqualTo(id);
    }
}
