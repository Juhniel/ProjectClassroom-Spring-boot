package com.juhnkim.projectclassroom.service;

import com.juhnkim.projectclassroom.dao.AccountRepository;
import com.juhnkim.projectclassroom.entity.Account;
import com.juhnkim.projectclassroom.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> findAllByOrderByAuthorityId() {
        return accountRepository.findAllOrderByAuthorityId();
    }

    @Override
    public Account findByUsername(String username) {
        Optional<Account> result = accountRepository.findById(username);

        Account account;

        if(result.isPresent()) {
            account = result.get();
        } else {
            throw new RuntimeException("Did not find the user with username:" + username);
        }
        return account;
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void createNewAccount(User user) {

//        save(account);
    }

    @Override
    public String updateUser(Account account) {
        accountRepository.save(account);
        return "Update successful! Account with username " + account.getUsername() + "has been updated.";
    }

    @Override
    public void delete(Account account) {
        accountRepository.delete(account);
    }

    @Override
    public Account findByUserId(int userId) {
        return accountRepository.findByUserId(userId);
    }

    @Override
    public List<Account> findAllByAuthorityId(int id) {
        return accountRepository.findAllByAuthorityId(id);
    }
}
