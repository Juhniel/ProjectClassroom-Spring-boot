package com.juhnkim.projectclassroom.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "course_name")
    private String courseName;

    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<UserCourse> userCourseList;

    @OneToMany(
            mappedBy = "course",
            fetch = FetchType.LAZY)
    private List<UserGrade> userGradeList;


    public Course() {

    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<UserCourse> getUserCourseList() {
        return userCourseList;
    }

    public void setUserCourseList(List<UserCourse> userCourseList) {
        this.userCourseList = userCourseList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
