package com.juhnkim.projectclassroom.dao;

import com.juhnkim.projectclassroom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
