package com.juhnkim.projectclassroom.service;

import com.juhnkim.projectclassroom.dao.StudentCourseRepository;
import com.juhnkim.projectclassroom.entity.StudentCourse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseServiceImpl implements StudentCourseService{

    private StudentCourseRepository studentCourseRepository;

    public StudentCourseServiceImpl(StudentCourseRepository studentCourseRepository) {
        this.studentCourseRepository = studentCourseRepository;
    }

    @Override
    public void save(StudentCourse studentCourse) {
        studentCourseRepository.save(studentCourse);
    }

    @Override
    public String update(StudentCourse studentCourse) {
        studentCourseRepository.save(studentCourse);
        return "Student's grade has been successfully updated!";
    }

    @Override
    public void delete(StudentCourse studentCourse) {
        studentCourseRepository.delete(studentCourse);
    }

    @Override
    public List<StudentCourse> findAllStudentsByCourseId(int id) {
        return studentCourseRepository.findAllStudentsByCourseId(id);
    }

    @Override
    public List<StudentCourse> findAllCoursesByUsername(String username) {
        return studentCourseRepository.findAllCoursesByUsername(username);
    }
}
