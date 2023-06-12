package com.juhnkim.projectclassroom.dao;

import com.juhnkim.projectclassroom.entity.TeacherCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherCourseRepository extends JpaRepository<TeacherCourse, Integer> {

    @Query(value = "SELECT username FROM teacher_course WHERE course_id =?1", nativeQuery = true)
    List<TeacherCourse> findAllTeachersByCourseId(int id);

    @Query(value = "SELECT course_id FROM teacher_course WHERE username =?1", nativeQuery = true)
    List<TeacherCourse> findAllTeachersByUsername(String username);
}
