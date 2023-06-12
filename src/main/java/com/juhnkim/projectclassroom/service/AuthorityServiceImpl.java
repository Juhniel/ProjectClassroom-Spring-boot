package com.juhnkim.projectclassroom.service;

import com.juhnkim.projectclassroom.dao.AccountRepository;
import com.juhnkim.projectclassroom.dao.AuthorityRepository;
import com.juhnkim.projectclassroom.entity.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements AuthorityService{

    private final AuthorityRepository authorityRepository;

    @Autowired
    public AuthorityServiceImpl(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }


    @Override
    public void save(Authority authority) {
        authorityRepository.save(authority);
    }

    @Override
    public String update(Authority authority) {
        authorityRepository.save(authority);
        return "Authority was updated successfully!";
    }

    @Override
    public void delete(Authority authority) {
        authorityRepository.delete(authority);
    }
}
