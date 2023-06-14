package com.juhnkim.projectclassroom.service;

import com.juhnkim.projectclassroom.dao.TeacherCourseRepository;
import com.juhnkim.projectclassroom.entity.TeacherCourse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeacherCourseServiceImpl implements TeacherCourseService{

    private final TeacherCourseRepository teacherCourseRepository;

    public TeacherCourseServiceImpl(TeacherCourseRepository teacherCourseRepository) {
        this.teacherCourseRepository = teacherCourseRepository;
    }
    @Override
    public void save(TeacherCourse teacherCourse) {

        List<TeacherCourse> teacherCourseList = findAll();

        for(TeacherCourse theTeacherCourse : teacherCourseList) {
            if(theTeacherCourse.getCourse() == teacherCourse.getCourse() && theTeacherCourse.getAccount() == teacherCourse.getAccount()) {
                throw new IllegalArgumentException("Course already assigned to this student.");
            }
        }
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
    public List<TeacherCourse> findAll() {
        return teacherCourseRepository.findAll();
    }

    @Override
    public String findTeacherNameByCourseId(int id) {
        return teacherCourseRepository.findTeacherNameByCourseId(id);
    }

    @Override
    public List<TeacherCourse> findAllCoursesByUsername(String username) {
        return teacherCourseRepository.findAllTeachersByUsername(username);
    }

    @Override
    public List<Map<String, Object>> findCourseAndTeacherByTeacherUsername(String username) {
        return teacherCourseRepository.findCourseAndTeacherByTeacherUsername(username);
    }
}
