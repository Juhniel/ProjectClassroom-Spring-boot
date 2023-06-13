package com.juhnkim.projectclassroom.controller;

import com.juhnkim.projectclassroom.entity.Account;
import com.juhnkim.projectclassroom.entity.Course;
import com.juhnkim.projectclassroom.entity.User;
import com.juhnkim.projectclassroom.service.AccountService;
import com.juhnkim.projectclassroom.service.AuthorityService;
import com.juhnkim.projectclassroom.service.CourseService;
import com.juhnkim.projectclassroom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/admin")
public class AdminController {

    UserService userService;
    AuthorityService authorityService;
    AccountService accountService;
    CourseService courseService;

    @Autowired
    public AdminController(UserService userService, CourseService courseService, AuthorityService authorityService, AccountService accountService) {
        this.userService = userService;
        this.authorityService = authorityService;
        this.accountService = accountService;
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
}
