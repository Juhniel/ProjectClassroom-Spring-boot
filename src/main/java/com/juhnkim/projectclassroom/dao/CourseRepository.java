package com.juhnkim.projectclassroom.dao;

import com.juhnkim.projectclassroom.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
