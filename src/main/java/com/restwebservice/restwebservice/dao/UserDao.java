package com.restwebservice.restwebservice.dao;

import com.restwebservice.restwebservice.model.User;

import java.util.List;

public interface UserDao {
    List<User> list();

    User save(User user);

    User getById(String id);
}
