package org.sazails.service;

import org.sazails.dao.UserDAO;
import org.sazails.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    @Transactional
    public User find(int id) {
        return userDAO.find(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDAO.delete(id);
    }
}
