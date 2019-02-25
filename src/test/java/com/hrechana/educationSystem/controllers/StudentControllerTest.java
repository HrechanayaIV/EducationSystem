package com.hrechana.educationSystem.controllers;

import com.hrechana.educationSystem.EducationSystemApplication;
import com.hrechana.educationSystem.entity.Student;
import com.hrechana.educationSystem.services.StudentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
@ContextConfiguration(classes = EducationSystemApplication.class)
public class StudentControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private StudentServiceImpl studentService;

    @Test
    public void testCreate() throws Exception{
        this.mvc.perform(post("/student").contentType(MediaType.APPLICATION_JSON)
                .content(STUDENT_JSON_CREATE)
        ).andExpect(status().isCreated());
    }

    @Test
    public void testGetStudentById() throws Exception {
        given(this.studentService.getById(1L))
                .willReturn(new Student(1L,"Inna", "SpecializationTest1"));
        this.mvc.perform(get("/student/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().json(STUDENT_JSON_1));
    }

    @Test
    public void testGetAllStudent() throws Exception {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1L,"Inna", "SpecializationTest1"));
        students.add(new Student(2L,"Anna", "SpecializationTest2"));
        given(this.studentService.getAll())
                .willReturn(students);
        this.mvc.perform(get("/students").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().json("[\n" + STUDENT_JSON_1 + ",\n" + STUDENT_JSON_2 + "\n]"));
    }

    @Test
    public void testUpdateStudent() throws Exception{
        this.mvc.perform(put("/student")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(STUDENT_JSON_UPDATE)
                ).andExpect(status().isOk());
    }

    @Test
    public void testDeleteStudent() throws Exception {
        this.mvc.perform(delete("/student/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    private static final String STUDENT_JSON_CREATE =
            "{" +
                    "\"nameVies\":\"Inna\"," +
                    "\"specialization\":\"SpecializationTest1\"" +
                    "}";

    private static final String STUDENT_JSON_1 =
            "{\n" +
                    "\"id\": 1,\n" +
                    "\"nameView\": \"Inna\",\n" +
                    "\"specialization\": \"SpecializationTest1\",\n" +
                    "\"university\": null\n" +
                    "}";

    private static final String STUDENT_JSON_2 =
            "{\n" +
                    "\"id\": 2,\n" +
                    "\"nameView\": \"Anna\",\n" +
                    "\"specialization\": \"SpecializationTest2\",\n" +
                    "\"university\": null\n" +
                    "}";

    private static final String STUDENT_JSON_UPDATE =
            "{" +
                    "\"id\":\"1\"," +
                    "\"nameVies\":\"updatesName\"," +
                    "\"specialization\":\"updatedSpecialization\"" +
                    "}";
}
