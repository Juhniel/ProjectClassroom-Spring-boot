package com.juhnkim.projectclassroom.controller;

import com.juhnkim.projectclassroom.entity.Account;
import com.juhnkim.projectclassroom.entity.Authority;
import com.juhnkim.projectclassroom.entity.User;
import com.juhnkim.projectclassroom.service.AccountService;
import com.juhnkim.projectclassroom.service.AuthorityService;
import com.juhnkim.projectclassroom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/classroom/users")
public class UserController {

    private UserService userService;

    private AccountService accountService;

    private AuthorityService authorityService;


    @Autowired
    public UserController(UserService userService, AccountService accountService, AuthorityService authorityService) {
        this.userService = userService;
        this.accountService = accountService;
        this.authorityService = authorityService;
    }

    @GetMapping("")
    public String showUsers(Model model) {
        List<Map<String, Object>> usersWithAuthorities = userService.findAllUsersWithAuthorities();
        model.addAttribute("usersWithAuthorities", usersWithAuthorities);

        return "userList";
    }




}
