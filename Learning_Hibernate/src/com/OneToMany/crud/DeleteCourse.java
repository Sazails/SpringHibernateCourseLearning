package com.OneToMany.crud;

import com.OneToMany.entity.Course;
import com.OneToMany.entity.Instructor;
import com.OneToMany.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourse {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("com/OneToMany/hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                addAnnotatedClass(Course.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            // Start transaction
            session.beginTransaction();

            // Get course
            int id = 10;
            Course course = session.get(Course.class, id);

            // Delete course
            session.delete(course);

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
