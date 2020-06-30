package com.BasicsAndCrud.crud;

import com.BasicsAndCrud.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadUser {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("com/BasicsAndCrud/hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{
            // Create user object
            Student user = new Student("Tiger", "Boy", "Tigro@mail.com");

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
            Student gotUser = session.get(Student.class, user.getId());

            // Read user
            System.out.println("Got: " + gotUser.toString());

            // Commit transaction
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
