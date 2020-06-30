package com.ManyToMany.crud;

import com.ManyToMany.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForStudent {
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

            // Create courses
            Course course1 = new Course("Java - Programming for beginners!");
            Course course2 = new Course("Java Programming Basics");
            Course course3 = new Course("The science of clouds.");

            // Add student to created courses
            course1.addStudent(student);
            course2.addStudent(student);
            course3.addStudent(student);

            // Save courses
            session.save(course1);
            session.save(course2);
            session.save(course3);

            // Commit transaction
            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
