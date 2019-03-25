package com.stackroute.springredis;

import com.stackroute.springredis.model.User;

import java.util.Map;

public interface UserRepository {

    //various CRUD Operation method calls
    void save(User user);
    Map<String, User> findAll();
    User findById(String id);
    void update(User user);
    void delete(String id);
}
