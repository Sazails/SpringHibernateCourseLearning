package com.sazails.spring.dao;

import com.sazails.spring.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        // Get hibernate session
        Session session = sessionFactory.getCurrentSession();

        // Create query
        Query<Customer> query = session.createQuery("from Customer", Customer.class);

        // Execute query and get results
        List<Customer> customers = query.getResultList();

        // Return results
        return customers;
    }

}
