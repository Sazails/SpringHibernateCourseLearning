package com.ManyToMany.crud;

import com.ManyToMany.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourse {
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
            int id = 10;
            Course course = session.get(Course.class, id);

            // Print results
            System.out.println("Deleting course: " + course.getTitle());
            System.out.println("Students removed from '" + course.getTitle() + "' course are " + course.getStudents().toString());

            // Delete course
            session.delete(course);

            // Commit transaction
            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
