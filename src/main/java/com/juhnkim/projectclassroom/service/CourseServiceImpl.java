package com.juhnkim.projectclassroom.service;

import com.juhnkim.projectclassroom.dao.CourseRepository;
import com.juhnkim.projectclassroom.entity.Course;
import com.juhnkim.projectclassroom.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public String update(Course course) {
        return "The " + course.getCourseName() + " has been updated!";
    }

    @Override
    public void delete(Course course) {
        courseRepository.delete(course);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(int id) {

        Optional<Course> result = courseRepository.findById(id);

        Course course;

        if(result.isPresent()) {
            course = result.get();
        } else {
            throw new RuntimeException("Did not find the course with id:" + id);
        }

        return course;
    }
}
