package com.juhnkim.projectclassroom.service;

import com.juhnkim.projectclassroom.entity.Course;
import com.juhnkim.projectclassroom.entity.StudentCourse;
import com.juhnkim.projectclassroom.entity.User;

import java.util.List;

public interface StudentCourseService {

    void save(StudentCourse studentCourse);

    String update(StudentCourse studentCourse);

    void delete(StudentCourse studentCourse);

    List<StudentCourse> findAll();

    List<StudentCourse> findAllStudentsByCourseId(int id);

    List<StudentCourse> findAllCoursesByUsername(String username);

}
