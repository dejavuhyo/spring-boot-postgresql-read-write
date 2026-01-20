package com.example.readwrite.service;

import com.example.readwrite.model.User;

import java.util.List;

public interface UserService {
    // Write 관련 메서드
    void registerUser(User user);
    void modifyUser(User user);
    void removeUser(Long id);

    // Read 관련 메서드
    User getUserById(Long id);
    List<User> getAllUsers();
}
