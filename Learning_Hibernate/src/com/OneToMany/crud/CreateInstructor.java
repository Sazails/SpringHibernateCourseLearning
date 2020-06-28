package com.OneToMany.crud;

import com.OneToMany.entity.Course;
import com.OneToMany.entity.Instructor;
import com.OneToMany.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructor {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("com/OneToMany/hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                addAnnotatedClass(Course.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            // Create objects
            Instructor instructor = new Instructor("Gerry", "Drum", "gerryDrum@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("youtube.com/channel/drumWithGerry", "Drumming");

            // Link objects
            instructor.setInstructorDetail(instructorDetail);

            // Start transaction
            session.beginTransaction();

            // Save instructor (The 'CascadeType.ALL' annotation inside 'Instructor' means that it will also save the 'InstructorDetail' object)
            session.save(instructor);

            // Commit transaction
            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
