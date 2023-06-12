package com.juhnkim.projectclassroom.dao;

import com.juhnkim.projectclassroom.entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer> {
    @Query(value = "SELECT username FROM student_course WHERE course_id = ?1", nativeQuery = true)
    List<StudentCourse> findAllStudentsByCourseId(int id);

    @Query(value = "SELECT course_id FROM student_course WHERE username = ?1", nativeQuery = true)
    List<StudentCourse> findAllCoursesByUsername(String username);

}
