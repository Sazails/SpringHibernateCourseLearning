package com.OneToMany.crud;

import com.OneToMany.entity.Course;
import com.OneToMany.entity.Instructor;
import com.OneToMany.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourses {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("com/OneToMany/hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                addAnnotatedClass(Course.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            // Start transaction
            session.beginTransaction();

            // Get instructor by id
            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);

            // Create courses
            Course course1 = new Course("Drumming 101");
            Course course2 = new Course("Drumming - From beginner to pro.");

            // Add courses to instructor
            instructor.add(course1);
            instructor.add(course2);

            // Save courses
            session.save(course1);
            session.save(course2);

            // Commit transaction
            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
