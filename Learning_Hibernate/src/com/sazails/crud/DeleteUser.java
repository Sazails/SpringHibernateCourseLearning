package com.sazails.crud;

import com.sazails.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteUser {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{
            int userId = 15;

            // Start transaction
            session.beginTransaction();


            // Get user object
            User user = session.get(User.class, userId);

            // Delete user
            System.out.println("Deleting user: " + user.toString());
            session.delete(user);


            // Delete user (another approach)
            System.out.println("Deleting user with id (22, 23)");
            session.createQuery("DELETE FROM User WHERE id > 21 AND id < 24").executeUpdate();

            // Commit transaction
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
