package com.juhnkim.projectclassroom.dao;

import com.juhnkim.projectclassroom.entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer> {
}
