package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by shantanu on 9/8/16.
 */
public interface UserRepository extends JpaRepository<Roles, String> {

    List<Roles> findByUsername(String username);
}

