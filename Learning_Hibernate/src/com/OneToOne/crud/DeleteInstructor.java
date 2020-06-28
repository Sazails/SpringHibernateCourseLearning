package com.OneToOne.crud;

import com.OneToOne.entity.Instructor;
import com.OneToOne.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructor {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("com/OneToOne/hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            // Start transaction
            session.beginTransaction();

            // Get instructor by id
            int id = 4;
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println("Got: " + instructor.toString());

            // Delete instructor (The 'CascadeType.ALL' annotation inside 'Instructor' means that it will also delete the 'InstructorDetail' object)
            if(instructor != null){
                session.delete(instructor);
            }

            // Commit transaction
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
