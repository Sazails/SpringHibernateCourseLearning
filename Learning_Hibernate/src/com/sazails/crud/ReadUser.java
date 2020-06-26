package com.sazails.crud;

import com.sazails.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadUser {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{
            // Create user object
            User user = new User("Tiger", "Boy", "Tigro@mail.com");

            // Start transaction
            session.beginTransaction();

            // Save user object
            session.save(user);

            // Commit transaction
            session.getTransaction().commit();

            /////////////////////

            // Read user
            System.out.println("Saved: " + user.toString());

            // Get new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // Get user based on ID
            User gotUser = session.get(User.class, user.getId());

            // Read user
            System.out.println("Got: " + gotUser.toString());

            // Commit transaction
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
