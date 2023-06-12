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



    @GetMapping("/home")
    public String showMainPage() {

        return "home";
    }




}
