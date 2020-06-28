package com.OneToMany.crud;

import com.OneToMany.entity.Course;
import com.OneToMany.entity.Instructor;
import com.OneToMany.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCourses {
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
            System.out.println("Instructor: " + instructor.toString());

            // Get courses from instructor
            System.out.println("Courses: " + instructor.getCourses());

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
