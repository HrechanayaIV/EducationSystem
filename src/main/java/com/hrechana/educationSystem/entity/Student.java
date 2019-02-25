package com.hrechana.educationSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Long id;

    @Column(name = "name_view")
    private String nameView;

    @Column(name = "specialization")
    private String specialization;

    @JsonIgnoreProperties("students")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "university_id")
    private University university;


    public Student() {
    }

    public Student(String nameView, String specialization) {
        this.nameView = nameView;
        this.specialization = specialization;
    }

    public Student(Long id, String nameView, String specialization){
        this.id = id;
        this.nameView = nameView;
        this.specialization = specialization;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameView() {
        return nameView;
    }

    public void setNameView(String nameView) {
        this.nameView = nameView;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id) &&
                nameView.equals(student.nameView) &&
                specialization.equals(student.specialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameView, specialization);
    }

}
