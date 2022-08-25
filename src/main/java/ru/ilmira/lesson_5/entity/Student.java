package ru.ilmira.lesson_5.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
    @SequenceGenerator(name = "id", sequenceName = "id")
    private Long id;

    private String name;

    private Integer mark;

    public Student(String name, Integer mark) {
        this.name = name;
        this.mark = mark;
    }

    public Student() {

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

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student {id= " + id + ", name= " + name + ", mark= " + mark + "}";
    }
}
