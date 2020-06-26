package com.sazails.crud;

import com.sazails.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKey {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{
            // Create user object
            User[] users = new User[3];
            users[0] = new User("Bob", "Bills", "BobbyBills@mail.com");
            users[1] = new User("Tom", "Key", "TomKey@bail.com");
            users[2] = new User("George", "Lamar", "GeorgeLamar@mail.com");

            // Start transaction
            session.beginTransaction();

            // Save user objects
            for(User user : users){
                session.save(user);
            }

            // Commit transaction
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
