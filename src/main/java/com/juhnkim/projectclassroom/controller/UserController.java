package com.juhnkim.projectclassroom.controller;

import com.juhnkim.projectclassroom.entity.Account;
import com.juhnkim.projectclassroom.entity.Authority;
import com.juhnkim.projectclassroom.entity.User;
import com.juhnkim.projectclassroom.service.AccountService;
import com.juhnkim.projectclassroom.service.AuthorityService;
import com.juhnkim.projectclassroom.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/classroom/users")
public class UserController {

    private UserService userService;

    private AccountService accountService;

    private AuthorityService authorityService;


    public UserController(UserService userService, AccountService accountService, AuthorityService authorityService) {
        this.userService = userService;
        this.accountService = accountService;
        this.authorityService = authorityService;
    }

    @GetMapping("")
    public String showUsers(Model model) {

        List<User> userList = userService.findAllByLastName();

        model.addAttribute("users", userList);
        return "userList";
    }

    @PostMapping("/createAccount")
    public String createAccount(@RequestParam int userId) {

        User user = userService.findById(userId);

        // create new account object
        Account account = new Account(user.getFirstName(), user.getFirstName(), Timestamp.valueOf(LocalDateTime.now()), null);

        account.setAuthority(authorityService.findById(2));

        account.setUser(user);


        // save the account object
        accountService.save(account);

        // redirect
        return "redirect:/classroom/users";
    }
}
