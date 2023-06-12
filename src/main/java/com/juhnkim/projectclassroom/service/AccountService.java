package com.juhnkim.projectclassroom.service;

import com.juhnkim.projectclassroom.entity.Account;
import com.juhnkim.projectclassroom.entity.User;

import java.util.List;

public interface AccountService {

    List<Account> findAll();
    List<Account> findAllByOrderByAuthorityId(int id);

    Account findByUsername(String username);

    void save(Account account);

    void createNewAccount(User user);

    String updateUser(Account account);
    void delete(Account account);
}
