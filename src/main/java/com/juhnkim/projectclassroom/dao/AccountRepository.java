package com.juhnkim.projectclassroom.dao;

import com.juhnkim.projectclassroom.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {

    @Query(value = "SELECT * FROM account ORDER BY authority_id", nativeQuery = true)
    List<Account> findAllOrderByAuthorityId();

    @Query(value = "SELECT * FROM account WHERE user_id = ?", nativeQuery = true)
    Account findByUserId(int userId);

    @Query(value = "SELECT * FROM account WHERE authority_id = ?", nativeQuery = true)
    List<Account> findAllByAuthorityId(int id);
}
