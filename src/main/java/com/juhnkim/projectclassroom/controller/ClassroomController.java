package com.juhnkim.projectclassroom.controller;

import com.juhnkim.projectclassroom.entity.Account;
import com.juhnkim.projectclassroom.entity.StudentCourse;
import com.juhnkim.projectclassroom.entity.TeacherCourse;
import com.juhnkim.projectclassroom.service.AccountService;
import com.juhnkim.projectclassroom.service.StudentCourseService;
import com.juhnkim.projectclassroom.service.TeacherCourseService;
import com.juhnkim.projectclassroom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/classroom")
public class ClassroomController {

    private AccountService accountService;
    private TeacherCourseService teacherCourseService;
    private StudentCourseService studentCourseService;


   @Autowired
    public ClassroomController(TeacherCourseService teacherCourseService, StudentCourseService studentCourseService, AccountService accountService) {
        this.teacherCourseService = teacherCourseService;
        this.studentCourseService = studentCourseService;
        this.accountService = accountService;
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

            // Här hämtar vi studentens kurser
            List<StudentCourse> studentCourseList = studentCourseService.findAllCoursesByUsername(loggedInAccount.getUsername());

            // Sedan ska vi spara studentens kurs_id för varje kurs dem har

            // och med det id:et ska vi hämta alla lärare som håller i den kursen

            List<TeacherCourse> teacherCourseList = teacherCourseService.findAllTeachersByCourseId();
        }



        return "home";
    }

    @GetMapping("")
    public String returnToMain() {
        return "home";
    }

}
