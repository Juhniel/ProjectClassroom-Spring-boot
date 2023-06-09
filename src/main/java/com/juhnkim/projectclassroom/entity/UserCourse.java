package com.juhnkim.projectclassroom.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user_course")
public class UserCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private List<Account> accountList;

    @ManyToMany
    private List<Course> courseList;

    public UserCourse() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "UserCourse{" +
                "id=" + id +
                '}';
    }
}
