package com.OneToManyUnidirectional.crud;

import com.OneToManyUnidirectional.entity.Course;
import com.OneToManyUnidirectional.entity.Instructor;
import com.OneToManyUnidirectional.entity.InstructorDetail;
import com.OneToManyUnidirectional.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseAndReviews {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("com/OneToManyUnidirectional/hibernate.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                addAnnotatedClass(Course.class).
                addAnnotatedClass(Review.class).
                buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            // Start transaction
            session.beginTransaction();

            int id = 10;

            // Create course
            Course course = session.get(Course.class, id);

            System.out.println("Course: " + course.getTitle());
            System.out.println("Reviews: " + course.getReviews());

            // The "cascade all" option will also delete all the reviews linked to the course.
            session.delete(course);

            // Commit transaction
            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
