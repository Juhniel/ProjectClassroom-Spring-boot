package com.juhnkim.projectclassroom.service;

import com.juhnkim.projectclassroom.entity.StudentCourse;
import com.juhnkim.projectclassroom.entity.TeacherCourse;

import java.util.List;

public interface TeacherCourseService {

    void save(TeacherCourse teacherCourse);

    String update(TeacherCourse teacherCourse);

    void delete(TeacherCourse teacherCourse);

    List<TeacherCourse> findAll();

    List<TeacherCourse> findAllTeachersByCourseId(int id);

    List<TeacherCourse> findAllCoursesByUsername(String username);
}
