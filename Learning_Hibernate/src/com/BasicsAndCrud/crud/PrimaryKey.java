package com.BasicsAndCrud.crud;

import com.BasicsAndCrud.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKey {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("com/BasicsAndCrud/hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{
            // Create user object
            Student[] users = new Student[3];
            users[0] = new Student("Bob", "Bills", "BobbyBills@mail.com");
            users[1] = new Student("Tom", "Key", "TomKey@bail.com");
            users[2] = new Student("George", "Lamar", "GeorgeLamar@mail.com");

            // Start transaction
            session.beginTransaction();

            // Save user objects
            for(Student user : users){
                session.save(user);
            }

            // Commit transaction
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
