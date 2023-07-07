package com.example.pp312.service;




import com.example.pp312.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    Object getUserById(long id);
    void addUser(User user);
    void deleteUser(long id);
    void updateUser(User user);
}
