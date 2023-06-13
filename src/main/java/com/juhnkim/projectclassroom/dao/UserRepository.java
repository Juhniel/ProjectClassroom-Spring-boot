package com.juhnkim.projectclassroom.dao;

import com.juhnkim.projectclassroom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface UserRepository extends JpaRepository<User, Integer> {

    // custom method for sorting users by last name
    @Query(value = "SELECT user.*, authority.authority, account.username "
            + "FROM user "
            + "LEFT JOIN account ON user.id = account.user_id "
            + "LEFT JOIN authority ON account.authority_id = authority.id "
            + "ORDER BY FIELD(authority.id, 2, 1), user.id", nativeQuery = true)
    List<Map<String, Object>> findAllUsersWithAuthorities();
    List<User> findAllByOrderByLastNameAsc();
}
