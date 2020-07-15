package org.sazails.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.sazails.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAOHibernateImpl implements UserDAO {

    private EntityManager entityManager;

    public UserDAOHibernateImpl(EntityManager manager){
        entityManager = manager;
    }

    @Override
    public List<User> findAll() {
        // Get hibernate session
        Session session = entityManager.unwrap(Session.class);
        // Create query
        Query<User> query = session.createQuery("FROM User", User.class);
        // Get result list
        List<User> users = query.getResultList();
        // Return result list
        return users;
    }

    @Override
    public User find(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(User.class, id);
    }

    @Override
    public void save(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
    }

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("DELETE FROM User WHERE id=:userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }
}
