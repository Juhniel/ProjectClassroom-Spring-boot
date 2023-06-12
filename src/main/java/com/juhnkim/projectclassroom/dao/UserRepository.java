package com.juhnkim.projectclassroom.dao;

import com.juhnkim.projectclassroom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    // custom method for sorting users by last name

    public List<User> findAllByOrderByLastNameAsc();
}
