package com.juhnkim.projectclassroom.service;

import com.juhnkim.projectclassroom.dao.AccountRepository;
import com.juhnkim.projectclassroom.dao.AuthorityRepository;
import com.juhnkim.projectclassroom.entity.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Authority findById(int id) {
        Optional<Authority> result = authorityRepository.findById(id);
        Authority authority;

        if(result.isPresent()) {
            authority = result.get();
        }else {
            throw new RuntimeException("Did not find the authority with the id: " + id);
        }

        return authority;
    }

    @Override
    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }
}
