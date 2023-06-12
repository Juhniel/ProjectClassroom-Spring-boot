package com.juhnkim.projectclassroom.dao;

import com.juhnkim.projectclassroom.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
