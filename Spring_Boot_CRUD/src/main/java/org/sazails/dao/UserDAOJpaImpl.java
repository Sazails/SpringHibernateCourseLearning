package org.sazails.dao;

import org.sazails.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDAOJpaImpl implements UserDAO {

    private EntityManager entityManager;

    @Autowired
    public UserDAOJpaImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {
        Query query = entityManager.createQuery("FROM User");
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    public User find(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        User tempUser = entityManager.merge(user);
        user.setId(tempUser.getId());
    }

    @Override
    public void delete(int id) {
        Query query = entityManager.createQuery("DELETE FROM User WHERE id=:userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }
}
