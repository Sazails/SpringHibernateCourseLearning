package com.EagerVsLazy.crud;

import com.EagerVsLazy.entity.Course;
import com.EagerVsLazy.entity.Instructor;
import com.EagerVsLazy.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazy {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("com/EagerVsLazy/hibernate.cfg.xml").
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

            // Get courses from instructor (stores courses into memory)
            System.out.println("Courses: " + instructor.getCourses());

            // Commit transaction
            session.getTransaction().commit();

            // End session
            session.close();

            // Get courses from instructor (this now works because instructor.getCourses() was called into memory before the session.close())
            System.out.println("Courses: " + instructor.getCourses());
        }catch (Exception ex){
            ex.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }

        /*try{
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
        }*/
    }
}
