package org.sazails.service;

import org.sazails.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User find(int id);
    void save(User user);
    void delete(int id);
}
