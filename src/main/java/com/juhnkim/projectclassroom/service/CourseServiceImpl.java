package com.juhnkim.projectclassroom.service;

import com.juhnkim.projectclassroom.dao.CourseRepository;
import com.juhnkim.projectclassroom.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void save(Course course) {

    }

    @Override
    public String update(Course course) {
        return null;
    }

    @Override
    public void delete(Course course) {

    }

    @Override
    public List<Course> findAll() {
        return null;
    }

    @Override
    public Course findById(int id) {
        return null;
    }
}
