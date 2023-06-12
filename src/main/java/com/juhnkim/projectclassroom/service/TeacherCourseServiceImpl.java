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
        teacherCourseRepository.save(teacherCourse);
    }

    @Override
    public String update(TeacherCourse teacherCourse) {
        teacherCourseRepository.save(teacherCourse);
        return "Teacher's course has been updated successfully!";
    }

    @Override
    public void delete(TeacherCourse teacherCourse) {
        teacherCourseRepository.delete(teacherCourse);
    }

    @Override
    public List<TeacherCourse> findAllTeachersByCourseId(int id) {
        return teacherCourseRepository.findAllTeachersByCourseId(id);
    }

    @Override
    public List<TeacherCourse> findAllCoursesByUsername(String username) {
        return teacherCourseRepository.findAllTeachersByUsername(username);
    }
}
