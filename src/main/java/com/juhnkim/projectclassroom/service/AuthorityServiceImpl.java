package com.juhnkim.projectclassroom.service;

import com.juhnkim.projectclassroom.dao.AccountRepository;
import com.juhnkim.projectclassroom.dao.AuthorityRepository;
import com.juhnkim.projectclassroom.entity.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements AuthorityService{

    private AuthorityRepository authorityRepository;

    @Autowired
    public AuthorityServiceImpl(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }


    @Override
    public void save(Authority authority) {

    }

    @Override
    public String update(Authority authority) {
        return null;
    }

    @Override
    public void delete(Authority authority) {

    }
}
