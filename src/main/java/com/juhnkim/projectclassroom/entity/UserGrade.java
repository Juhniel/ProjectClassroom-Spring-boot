package com.juhnkim.projectclassroom.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user_grade")
public class UserGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "grade")
    private String grade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "username")
    private Account account;


}
