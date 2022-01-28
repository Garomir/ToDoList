package com.ramich.ToDoList.services;


import com.ramich.ToDoList.entities.User;

import java.util.List;

public interface UserService {
    User saveUser (User user);
    User findByUsername (String username);
    List<User> findAll();
}
