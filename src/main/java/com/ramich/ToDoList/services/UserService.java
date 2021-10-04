package com.ramich.ToDoList.services;


import com.ramich.ToDoList.entities.User;

public interface UserService {
    void saveUser (User user);
    User findByUsername (String username);
}
