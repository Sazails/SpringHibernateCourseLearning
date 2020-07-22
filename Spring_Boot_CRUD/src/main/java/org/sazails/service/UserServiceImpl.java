package org.sazails.service;

import org.sazails.dao.UserRepository;
import org.sazails.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

//    private UserDAO userDAO;
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /*@Autowired
    public UserServiceImpl(@Qualifier("userDAOJpaImpl")UserDAO userDAO){
        this.userDAO = userDAO;
    }*/

    /*@Autowired
    public UserServiceImpl(UserDAO userDAO){
        this.userDAO = userDAO;
    }*/

    @Override
    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
//    @Transactional
    public User find(int id) {
        Optional<User> user = userRepository.findById(id);

        User tempUser = null;
        if(user.isPresent()){
            tempUser = user.get();
        }else {
            throw new RuntimeException("User with id '" + id + "' not found!");
        }

        return tempUser;
    }

    @Override
//    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
//    @Transactional
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    /*@Override
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
    }*/
}
