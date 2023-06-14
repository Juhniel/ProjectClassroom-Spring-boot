package com.juhnkim.projectclassroom.controller;

import com.juhnkim.projectclassroom.entity.Account;
import com.juhnkim.projectclassroom.entity.Course;
import com.juhnkim.projectclassroom.entity.StudentCourse;
import com.juhnkim.projectclassroom.entity.TeacherCourse;
import com.juhnkim.projectclassroom.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/classroom")
public class ClassroomController {

    private AccountService accountService;
    private TeacherCourseService teacherCourseService;
    private StudentCourseService studentCourseService;
    private CourseService courseService;


   @Autowired
    public ClassroomController(TeacherCourseService teacherCourseService, StudentCourseService studentCourseService, AccountService accountService, CourseService courseService) {
        this.teacherCourseService = teacherCourseService;
        this.studentCourseService = studentCourseService;
        this.accountService = accountService;
        this.courseService = courseService;
    }

    @GetMapping("/home")
    public String showMainPage(Model model) {

        // SecurityContextHolder - This class contains the details of the security data associated with the current execution
        // getContext() - returns the securityContext object. (details of the currently authenticated user)
        // getAuthentication() = - returns Authentication object that contains the principal like userdetails, username and authority.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Save to principal object
        Object principal = authentication.getPrincipal();

        Account loggedInAccount;
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();

            loggedInAccount = accountService.findByUsername(username);
            model.addAttribute("loggedInUser", loggedInAccount);

            System.out.println(username);
            if(loggedInAccount.getAuthority().getId() == 1) {
                System.out.println(loggedInAccount.getAuthority().getId());
                List<Map<String, Object>> studentCourseInfoList = studentCourseService.findCourseAndTeacherByStudentUsername(username);
                model.addAttribute("courseInfo", studentCourseInfoList);
            }else if(loggedInAccount.getAuthority().getId() == 2) {
                System.out.println(loggedInAccount.getAuthority().getId());
                List<Map<String, Object>> teacherCourseInfoList = teacherCourseService.findCourseAndTeacherByTeacherUsername(username);
                model.addAttribute("courseInfo", teacherCourseInfoList);

            }else {
                // Hämta alla kurser för admin
                System.out.println(loggedInAccount.getAuthority().getId());
            }

        }
            return "home";
        }

        @GetMapping("")
        public String returnToMain () {
            return "home";
        }

}
