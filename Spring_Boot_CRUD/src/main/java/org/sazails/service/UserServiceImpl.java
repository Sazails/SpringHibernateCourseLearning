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

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
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
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
