package com.juhnkim.projectclassroom.service;

import com.juhnkim.projectclassroom.dao.TeacherCourseRepository;
import com.juhnkim.projectclassroom.entity.TeacherCourse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherCourseServiceImpl implements TeacherCourseService{

    private TeacherCourseRepository teacherCourseRepository;

    public TeacherCourseServiceImpl(TeacherCourseRepository teacherCourseRepository) {
        this.teacherCourseRepository = teacherCourseRepository;
    }
    @Override
    public void save(TeacherCourse teacherCourse) {

    }

    @Override
    public String update(TeacherCourse teacherCourse) {
        return "";
    }

    @Override
    public void delete(TeacherCourse teacherCourse) {

    }

    @Override
    public List<TeacherCourse> findAllTeachersByCourseId(int id) {
        return null;
    }

    @Override
    public List<TeacherCourse> findAllCoursesByUsername(String username) {
        return null;
    }
}
