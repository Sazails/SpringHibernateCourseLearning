package com.BasicsAndCrud.crud;

import com.BasicsAndCrud.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateUser {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("com/BasicsAndCrud/hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{
            // Create user object
            Student user = new Student("Bob", "Bills", "BobbyBills@mail.com");

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
