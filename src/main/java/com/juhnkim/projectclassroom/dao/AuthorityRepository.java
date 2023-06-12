package com.juhnkim.projectclassroom.dao;

import com.juhnkim.projectclassroom.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
