package com.juhnkim.projectclassroom.service;

import com.juhnkim.projectclassroom.dao.UserRepository;
import com.juhnkim.projectclassroom.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public User findById(int id) {
        Optional<User> result = userRepository.findById(id);

        User user;

        if(result.isPresent()) {
            user = result.get();
        } else {
            throw new RuntimeException("Did not find the user with id:" + id);
        }

        return user;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public String updateUser(User user) {
        return "User " + user.getFirstName() + "has been updated!";
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}
