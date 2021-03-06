package com.BasicsAndCrud.crud;

import com.BasicsAndCrud.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryUser {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("com/BasicsAndCrud/hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{
            // Start transaction
            session.beginTransaction();

            // Query users (show all users)
            List<Student> users = session.createQuery("from Student").getResultList();

            // Display users
            displayUsers(users);

            // Query users (show users with id 13+)
            users = session.createQuery("from Student user where user.id > 12").getResultList();

            // Display users
            displayUsers(users);

            // Query users (don't show user with id of 12)
            users = session.createQuery("from Student user where user.id > 12 or user.id < 12").getResultList();

            // Display users
            displayUsers(users);

            // Query users (show users with email ending in "mail.com")
            users = session.createQuery("from Student user where user.email LIKE '%mail.com'").getResultList();

            // Display users
            displayUsers(users);

            // Commit transaction
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }

    private static void displayUsers(List<Student> users){
        for(Student user : users){
            System.out.println(user.toString());
        }
    }
}
