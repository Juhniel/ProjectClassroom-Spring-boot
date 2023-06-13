package com.juhnkim.projectclassroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/classroom")
public class ClassroomController {

    @GetMapping("/home")
    public String showMainPage() {

        return "home";
    }

    @GetMapping("")
    public String returnToMain() {
        return "home";
    }




}
