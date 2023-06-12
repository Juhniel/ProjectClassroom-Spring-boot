package com.juhnkim.projectclassroom.controller;

import com.juhnkim.projectclassroom.entity.Course;
import com.juhnkim.projectclassroom.entity.User;
import com.juhnkim.projectclassroom.service.CourseService;
import com.juhnkim.projectclassroom.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/classroom/admin")
public class AdminController {

    UserService userService;
    CourseService courseService;

    public AdminController(UserService userService, CourseService courseService) {
        this.userService = userService;
        this.courseService = courseService;
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
        return "redirect:/classroom/admin/addCourse";
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
        return "redirect:/classroom/admin/addUserForm";
    }
}
