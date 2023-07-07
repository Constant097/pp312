package com.example.pp312.dao;




import com.example.pp312.model.User;

import java.util.List;

public interface UserDao {

    List<User>getAllUsers();
    User getUserById(long id);
    void addUser(User user);
    void deleteUser(long id);
    void updateUser(User user);

}
