package com.user.project.userApp.services;

import com.user.project.userApp.entities.User;

import java.util.List;

public interface UserServiceInt {
    User findById(String id);

    List<User> findAll();

    List<User> findByAfmOrName(String text);

    User saveUser(User user);

    void deleteUser(User user);
}
