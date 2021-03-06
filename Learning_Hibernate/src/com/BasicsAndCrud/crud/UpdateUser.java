package com.BasicsAndCrud.crud;

import com.BasicsAndCrud.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateUser {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("com/BasicsAndCrud/hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{
            int userId = 14;

            // Start transaction
            session.beginTransaction();

            // Get user object
            Student user = session.get(Student.class, userId);

            // Update user
            user.setLastName("Chicken");

            // Commit transaction
            session.getTransaction().commit();

            // Get new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // Update emails
            session.createQuery("UPDATE Student SET email='test@mail.com'").executeUpdate();

            // Commit transaction
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
