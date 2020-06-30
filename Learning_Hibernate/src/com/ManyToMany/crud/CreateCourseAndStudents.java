package com.ManyToMany.crud;

import com.ManyToMany.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudents {
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

            // Create course
            Course course = new Course("How to program a program using a program with Java.");

            // Create students
            Student student1 = new Student("Red", "Groll", "redda@email.com");
            Student student2 = new Student("Marry", "Lane", "MarryLane@email.com");

            // Add students to course
            course.addStudent(student1);
            course.addStudent(student2);

            // Save students
            session.save(course);
            session.save(student1);
            session.save(student2);

            // Commit transaction
            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
