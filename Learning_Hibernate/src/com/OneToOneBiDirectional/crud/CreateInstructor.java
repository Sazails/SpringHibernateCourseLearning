package com.OneToOneBiDirectional.crud;

import com.OneToOneBiDirectional.entity.Instructor;
import com.OneToOneBiDirectional.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructor {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("com/OneToOneBiDirectional/hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            // Create objects
            Instructor instructor = new Instructor("Tod", "Hoover", "toddy@mail.com");
            InstructorDetail instructorDetail = new InstructorDetail("youtube.com/channel/ItsMeTodHooverReviews", "Tennis");

            // Link objects
            instructor.setInstructorDetail(instructorDetail);

            // Start transaction
            session.beginTransaction();

            // Save instructor (The 'CascadeType.ALL' annotation inside 'Instructor' means that it will also save the 'InstructorDetail' object)
            session.save(instructor);

            // Commit transaction
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
