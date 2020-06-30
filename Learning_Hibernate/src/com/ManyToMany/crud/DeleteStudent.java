package com.ManyToMany.crud;

import com.ManyToMany.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("com/ManyToMany/hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                addAnnotatedClass(Course.class).
                addAnnotatedClass(Review.class).
                addAnnotatedClass(Student.class).
                buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            // Start transaction
            session.beginTransaction();

            // Get course
            int id = 2;
            Student student = session.get(Student.class, id);

            // Print results
            System.out.println("Deleting student: " + student.toString());

            // Delete course
            session.delete(student);

            // Commit transaction
            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
