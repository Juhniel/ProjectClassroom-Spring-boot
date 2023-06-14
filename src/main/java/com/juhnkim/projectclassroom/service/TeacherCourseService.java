package com.juhnkim.projectclassroom.service;

import com.juhnkim.projectclassroom.entity.StudentCourse;
import com.juhnkim.projectclassroom.entity.TeacherCourse;

import java.util.List;
import java.util.Map;

public interface TeacherCourseService {

    void save(TeacherCourse teacherCourse);

    String update(TeacherCourse teacherCourse);

    void delete(TeacherCourse teacherCourse);

    List<TeacherCourse> findAll();

    String findTeacherNameByCourseId(int id);

    List<TeacherCourse> findAllCoursesByUsername(String username);

    List<Map<String, Object>> findCourseAndTeacherByTeacherUsername(String username);
}
