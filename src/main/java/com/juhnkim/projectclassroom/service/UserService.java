package com.juhnkim.projectclassroom.service;

import com.juhnkim.projectclassroom.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(int id);

    void save(User user);

    String updateUser(User user);
    void delete(User user);
}
