package com.juhnkim.projectclassroom.controller;

import com.juhnkim.projectclassroom.entity.User;
import com.juhnkim.projectclassroom.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/classroom")
public class ClassroomController {

    UserService userService;

    public ClassroomController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String showMainPage() {

        return "home";
    }

    @GetMapping("/add")
    public String addUser(Model model) {

        User user = new User();

        model.addAttribute("user", user);

        return "userForm";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        // save user
        userService.save(user);
        // redirect
        return "redirect:/classroom/add";
    }


    @GetMapping("/users")
    public String showStudentList() {
        return "userList";
    }

    @GetMapping("/createAccount")
    public String createAccount() {
        return "redirect:/classroom/userList";
    }
}
