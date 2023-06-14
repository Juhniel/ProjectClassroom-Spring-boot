package com.juhnkim.projectclassroom.dao;

import com.juhnkim.projectclassroom.entity.TeacherCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface TeacherCourseRepository extends JpaRepository<TeacherCourse, Integer> {

    @Query(value = "SELECT username FROM teacher_course WHERE course_id =?1", nativeQuery = true)
    String findTeacherNameByCourseId(int id);

    @Query(value = "SELECT course_id FROM teacher_course WHERE username =?1", nativeQuery = true)
    List<TeacherCourse> findAllTeachersByUsername(String username);

    @Query(value = "SELECT teacher_account.username AS teacher_username, "
            + "course.course_name "
            + "FROM teacher_course "
            + "JOIN course ON teacher_course.course_id = course.id "
            + "JOIN account AS teacher_account ON teacher_course.username = teacher_account.username "
            + "JOIN authority AS teacher_authority ON teacher_account.authority_id = teacher_authority.id "
            + "WHERE teacher_account.username = ?1 "
            + "AND teacher_authority.authority = 'ROLE_TEACHER';", nativeQuery = true)
    List<Map<String, Object>> findCourseAndTeacherByTeacherUsername(String username);

}
