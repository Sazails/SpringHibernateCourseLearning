package com.BasicsAndCrud.crud;

import com.BasicsAndCrud.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteUser {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("com/BasicsAndCrud/hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{
            // Temp id
            int userId = 15;

            // Start transaction
            session.beginTransaction();

            // Get user object
            Student user = session.get(Student.class, userId);

            // Delete user
            System.out.println("Deleting user: " + user.toString());
            session.delete(user);

            // Delete user (another approach)
            System.out.println("Deleting user with id (22, 23)");
            session.createQuery("DELETE FROM Student WHERE id > 21 AND id < 24").executeUpdate();

            // Commit transaction
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
