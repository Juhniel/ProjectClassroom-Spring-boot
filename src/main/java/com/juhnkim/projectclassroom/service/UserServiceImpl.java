package com.juhnkim.projectclassroom.service;

import com.juhnkim.projectclassroom.dao.UserRepository;
import com.juhnkim.projectclassroom.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public String updateUser(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }
}
