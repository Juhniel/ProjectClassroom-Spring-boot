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
@RequestMapping("/classroom/admin")
public class AdminController {

    UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/addUserForm")
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
        return "redirect:/classroom/admin/addUserForm";
    }
}
