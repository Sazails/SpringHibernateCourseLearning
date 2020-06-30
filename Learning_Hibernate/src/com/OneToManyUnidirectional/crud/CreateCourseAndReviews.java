package com.OneToManyUnidirectional.crud;

import com.OneToManyUnidirectional.entity.Course;
import com.OneToManyUnidirectional.entity.Instructor;
import com.OneToManyUnidirectional.entity.InstructorDetail;
import com.OneToManyUnidirectional.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviews {
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

            // Create course
            Course course = new Course("Learn to Java - Beginner to advanced.");

            // Create reviews
            course.addReview(new Review("Very clean and understandable course to follow."));
            course.addReview(new Review("Worth the money."));
            course.addReview(new Review("I am a bot."));

            // Save course and this updates all reviews too because of the "cascade all" option.
            session.save(course);

            // Commit transaction
            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
