package com.OneToOneBiDirectional.crud;

import com.OneToOneBiDirectional.entity.Instructor;
import com.OneToOneBiDirectional.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetail {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("com/OneToOneBiDirectional/hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            // Start transaction
            session.beginTransaction();

            // Get InstructorDetail object
            int id = 2;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            System.out.println("Got: " + instructorDetail.toString());

            // Commit transaction
            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
