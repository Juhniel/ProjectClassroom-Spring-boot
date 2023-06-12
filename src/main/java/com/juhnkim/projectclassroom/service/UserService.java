package com.juhnkim.projectclassroom.service;

import com.juhnkim.projectclassroom.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    List<User> findAllByLastName();

    User findById(int id);

    void save(User user);

    String updateUser(User user);
    void delete(User user);
}
