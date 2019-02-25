package com.hrechana.educationSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "university")
public class University implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "university_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @JsonIgnoreProperties("university")
    @OneToMany(mappedBy = "university", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Student> students;

    public University() {
    }

    public University(String name, String country, List<Student> students) {
        this.name = name;
        this.country = country;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                country.equals(that.country) &&
                students.equals(that.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country, students);
    }
}
