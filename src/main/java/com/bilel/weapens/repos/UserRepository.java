package com.bilel.weapens.repos;

import java.util.List;

import com.bilel.weapens.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
      User findByUsername (String username);

}
