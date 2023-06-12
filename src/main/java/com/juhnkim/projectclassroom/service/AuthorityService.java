package com.juhnkim.projectclassroom.service;

import com.juhnkim.projectclassroom.entity.Authority;

public interface AuthorityService {

    void save(Authority authority);

    String update(Authority authority);

    void delete(Authority authority);

    Authority findById(int id);
}
