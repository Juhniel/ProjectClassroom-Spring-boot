package com.juhnkim.projectclassroom.dao;

import com.juhnkim.projectclassroom.entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer> {
    @Query(value = "SELECT username FROM student_course WHERE course_id = ?1", nativeQuery = true)
    List<StudentCourse> findAllStudentsByCourseId(int id);

    @Query(value = "SELECT course_id FROM student_course WHERE username = ?1", nativeQuery = true)
    List<StudentCourse> findAllCoursesByUsername(String username);

@Query(value = "SELECT student_account.username AS student_username, "
    + "teacher_account.username AS teacher_username, "
    + "course.course_name "
    + "FROM student_course "
    + "JOIN course ON student_course.course_id = course.id "
    + "JOIN teacher_course ON student_course.course_id = teacher_course.course_id "
    + "JOIN account AS student_account ON student_course.username = student_account.username "
    + "JOIN authority AS student_authority ON student_account.authority_id = student_authority.id "
    + "JOIN account AS teacher_account ON teacher_course.username = teacher_account.username "
    + "JOIN authority AS teacher_authority ON teacher_account.authority_id = teacher_authority.id "
    + "WHERE student_account.username = ?1 "
    + "AND student_authority.authority = 'ROLE_STUDENT' "
    + "AND teacher_authority.authority = 'ROLE_TEACHER';", nativeQuery = true)
    List<Map<String, Object>> findCourseAndTeacherByStudentUsername(String studentUsername);
}
