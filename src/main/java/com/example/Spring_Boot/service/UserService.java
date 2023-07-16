package com.example.Spring_Boot.service;

import com.example.Spring_Boot.model.User;

import java.util.List;

public interface UserService  {

    List<User> getAllUsers();

    void saveUser(User user);

    void updateUser(User user);

    User getUserById(Long id);

    void delete(Long id);
}
