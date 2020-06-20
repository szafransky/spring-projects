package com.szafranski.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.szafranski.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	
	
	//need to inject the session factory
	@Autowired 
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		System.out.println("Entering getCustomer methodq");
		//get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		Customer cus = session.get(Customer.class, 1);
		System.out.println(cus);
		//create a query .. sort by last name
		
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		
		
		//execute query and get the list of customers
		List<Customer> customers = query.getResultList();
		System.out.println(customers);
		//return the results
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		Session session = sessionFactory.getCurrentSession();
		
		
		//  save/update customer
		session.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		//return the customer of a given id from the session
		return session.get(Customer.class, theId);
	}

	@Override
	public void deleteCustomer(int theId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query theQuery = session.createQuery("delete from Customer where id=:theCustomerId");
		
		theQuery.setParameter("theCustomerId", theId);
		
		theQuery.executeUpdate();
	}

}
