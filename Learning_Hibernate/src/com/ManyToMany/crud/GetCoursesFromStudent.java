package com.ManyToMany.crud;

import com.ManyToMany.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesFromStudent {
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

            // Get student
            int id = 3;
            Student student = session.get(Student.class, id);

            // Print results
            System.out.println("Student: " + student.toString());
            System.out.println("Courses: " + student.getCourses());

            // Commit transaction
            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
