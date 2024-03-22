package com.hasanur.ToDo.dao;

import com.hasanur.ToDo.entity.User;

public interface UserDao {

    User getUserById(Integer id);
    User findByEmail(String email);
    void addUser(User user);

}
