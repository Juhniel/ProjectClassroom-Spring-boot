package com.juhnkim.projectclassroom.service;

import com.juhnkim.projectclassroom.dao.AccountRepository;
import com.juhnkim.projectclassroom.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public Account findById(int id) {
        return null;
    }

    @Override
    public void save(Account account) {

    }

    @Override
    public String updateUser(Account account) {
        return null;
    }

    @Override
    public void delete(Account account) {

    }
}
