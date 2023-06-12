package com.juhnkim.projectclassroom.dao;

import com.juhnkim.projectclassroom.entity.TeacherCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherCourseRepository extends JpaRepository<TeacherCourse, Integer> {
}
