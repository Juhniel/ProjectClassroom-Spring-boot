package com.juhnkim.projectclassroom.controller;

import com.juhnkim.projectclassroom.entity.User;
import com.juhnkim.projectclassroom.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/classroom/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String showUsers(Model model) {

        List<User> userList = userService.findAllByLastName();

        model.addAttribute("users", userList);
        return "userList";
    }

    @PostMapping("/createAccount")
    public String createAccount(@ModelAttribute("users") User user) {
        // get user information


        // create new account object

        // save the account object


        // redirect
        return "redirect:/classroom/add";
    }


}
