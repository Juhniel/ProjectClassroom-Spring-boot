package com.juhnkim.projectclassroom.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "created")
    private Timestamp created;

    @Column(name = "updated")
    private Timestamp updated;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "authority_id")
    private Authority authority;

    @OneToMany(mappedBy = "account",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<TeacherCourse> teacherCourseList;

    @OneToMany(mappedBy = "account",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<StudentCourse> studentCourseList;


    public Account() {

    }


    public Account(String username, String password, Timestamp created, Timestamp updated, User user) {
        this.username = username;
        this.password = password;
        this.created = created;
        this.updated = updated;
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<TeacherCourse> getUserCourseList() {
        return teacherCourseList;
    }

    public void setUserCourseList(List<TeacherCourse> teacherCourseList) {
        this.teacherCourseList = teacherCourseList;
    }

    public List<StudentCourse> getUserGradeList() {
        return studentCourseList;
    }

    public void setUserGradeList(List<StudentCourse> studentCourseList) {
        this.studentCourseList = studentCourseList;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", user=" + user +
                '}';
    }
}
