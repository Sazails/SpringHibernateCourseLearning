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
        Query<Customer> query = session.createQuery("FROM Customer ORDER BY lastName", Customer.class);

        // Execute query and get results
        List<Customer> customers = query.getResultList();

        // Return results
        return customers;
    }

    @Override
    public Customer getCustomer(int id) {
        // Get hibernate session
        Session session = sessionFactory.getCurrentSession();

        // Get customer from database using id
        Customer customer = session.get(Customer.class, id);

        return customer;
    }

    @Override
    public void saveCustomer(Customer customer) {
        // Get hibernate session
        Session session = sessionFactory.getCurrentSession();

        // Save/Update customer
        session.saveOrUpdate(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        // Get hibernate session
        Session session = sessionFactory.getCurrentSession();

        // Delete customer by id (primary key)
        Query query = session.createQuery("DELETE FROM Customer WHERE id=:customerId");
        query.setParameter("customerId", id);
        query.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String searchName) {
        // Get hibernate session
        Session session = sessionFactory.getCurrentSession();

        Query query = null;

        // Search customers by firstName and lastName (search done in lowercase format)
        if(searchName != null && searchName.trim().length() > 0){
            // Search
            query = session.createQuery("FROM Customer WHERE LOWER(firstName) LIKE :name or LOWER(lastName) LIKE :name", Customer.class);
            query.setParameter("name", "%"+searchName.toLowerCase() + "%");
        }else{
            query = session.createQuery("FROM Customer", Customer.class);
        }

        // Return customer list by firstName/lastName that contain the "searchName" (return all customers if "searchName" input is not valid)
        List<Customer> customers = query.getResultList();
        return customers;
    }
}
