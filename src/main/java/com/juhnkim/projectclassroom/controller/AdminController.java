package com.juhnkim.projectclassroom.controller;

import com.juhnkim.projectclassroom.entity.*;
import com.juhnkim.projectclassroom.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    UserService userService;
    AuthorityService authorityService;
    AccountService accountService;
    CourseService courseService;
    StudentCourseService studentCourseService;
    TeacherCourseService teacherCourseService;

    @Autowired
    public AdminController(UserService userService,
                           CourseService courseService,
                           AuthorityService authorityService,
                           AccountService accountService,
                           StudentCourseService studentCourseService,
                           TeacherCourseService teacherCourseService) {
        this.userService = userService;
        this.authorityService = authorityService;
        this.accountService = accountService;
        this.courseService = courseService;
        this.studentCourseService = studentCourseService;
        this.teacherCourseService = teacherCourseService;
    }

    @GetMapping("/addCourse")
    public String addCourse(Model model) {

        Course course = new Course();

        model.addAttribute("course", course);

        return "courseForm";
    }

    @PostMapping("/saveCourse")
    public String saveUser(@ModelAttribute("course") Course course) {
        // save user
        courseService.save(course);
        // redirect
        return "redirect:/admin/addCourse";
    }

    @GetMapping("/addUserForm")
    public String addUser(Model model) {

        User user = new User();

        model.addAttribute("user", user);

        return "userForm";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        // save user
        userService.save(user);
        // redirect
        return "redirect:/admin/addUserForm";
    }

    @PostMapping("/createAccount")
    public String createAccount(@RequestParam int userId, @RequestParam int authorityId) {

        User user = userService.findById(userId);

        // create new account object
        Account account = new Account(user.getFirstName(), user.getFirstName(), Timestamp.valueOf(LocalDateTime.now()), null);

        account.setAuthority(authorityService.findById(authorityId));

        account.setUser(user);

        // save the account object
        accountService.save(account);

        // redirect
        return "redirect:/classroom/users";
    }

    @PostMapping("/updateAccount")
    public String updateAccount(@RequestParam int userId, @RequestParam int authorityId) {
        Account account = accountService.findByUserId(userId);

        account.setAuthority(authorityService.findById(authorityId));

        accountService.save(account);

        return "redirect:/classroom/users";
    }

    @GetMapping("/systems")
    public String showSystemsPage() {

        return "adminSystem";
    }

    @GetMapping("/students/courses")
    public String showStudentCourses(Model model) {
        List<Course> courseList = courseService.findAll();
        model.addAttribute("courses", courseList);

        List<Account> studentList = accountService.findAllByAuthorityId(1);

        model.addAttribute("students", studentList);

        return "addStudentCourse";
    }

    @GetMapping("/teachers/courses")
    public String showTeacherCourses(Model model) {

        List<Course> courseList = courseService.findAll();
        model.addAttribute("courses", courseList);

        List<Account> teachersList = accountService.findAllByAuthorityId(2);

        model.addAttribute("teachers", teachersList);

        return "addTeacherCourse";
    }


    @PostMapping("/teachers/addTeacherCourse")
    public String addTeacherCourse(@RequestParam String username, @RequestParam int course, Model model) {

        TeacherCourse teacherCourse = new TeacherCourse();

        Course theTeacherCourse = courseService.findById(course);
        Account theTeacherAccount = accountService.findByUsername(username);
        teacherCourse.setCourse(theTeacherCourse);
        teacherCourse.setAccount(theTeacherAccount);

        try {
            teacherCourseService.save(teacherCourse);
        }catch(IllegalArgumentException e) {
            model.addAttribute("duplicateCourseError", e.getMessage());
            return showTeacherCourses(model);
        }

        return "redirect:/admin/teachers/courses";
    }

    @PostMapping("/students/addStudentCourse")
    public String addStudentCourse(@RequestParam String username, @RequestParam int course, Model model) {

        StudentCourse studentCourse = new StudentCourse();

        Course theStudentCourse = courseService.findById(course);
        Account theStudentAccount = accountService.findByUsername(username);
        studentCourse.setCourse(theStudentCourse);
        studentCourse.setAccount(theStudentAccount);

        try{
            studentCourseService.save(studentCourse);

        }catch(IllegalArgumentException e){
            model.addAttribute("duplicateCourseError", e.getMessage());
            return showStudentCourses(model);
        }
        return "redirect:/admin/students/courses";
    }


}
