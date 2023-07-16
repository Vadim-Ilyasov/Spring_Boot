package com.example.Spring_Boot.repository;

import com.example.Spring_Boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
