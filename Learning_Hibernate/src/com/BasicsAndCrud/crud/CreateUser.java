package com.BasicsAndCrud.crud;

import com.BasicsAndCrud.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateUser {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("com/BasicsAndCrud/hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{
            // Create user object
            User user = new User("Bob", "Bills", "BobbyBills@mail.com");

            // Start transaction
            session.beginTransaction();

            // Save user object
            session.save(user);

            // Commit transaction
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
