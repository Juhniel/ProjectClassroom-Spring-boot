package com.juhnkim.projectclassroom.dao;

import com.juhnkim.projectclassroom.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {

    @Query(value = "SELECT username FROM account WHERE authority_id = ?1", nativeQuery = true)
    List<Account> findAllByOrderByAuthorityId(int id);
}
