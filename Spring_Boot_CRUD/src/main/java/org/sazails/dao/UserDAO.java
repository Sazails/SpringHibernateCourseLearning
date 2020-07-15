package org.sazails.dao;

import org.sazails.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> findAll();
    User find(int id);
    void save(User user);
    void delete(int id);
}
