package com.juhnkim.projectclassroom.service;

import com.juhnkim.projectclassroom.entity.Course;

import java.util.List;

public interface CourseService {

    void save(Course course);

    String update(Course course);

    void delete(Course course);

    List<Course> findAll();

    Course findById(int id);
}
