package com.restwebservice.restwebservice.dao;

import com.restwebservice.restwebservice.model.User;

import java.util.List;

public interface UserDao {
    List<User> list() throws Exception;

    User save(User user) throws Exception;

    User getById(String id) throws Exception;

    User update(String id, User user) throws Exception;

    User delete(String id) throws Exception;
}
