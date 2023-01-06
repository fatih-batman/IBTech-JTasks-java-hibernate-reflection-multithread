package dao;



import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import entities.*;
import jtaskProjects.jTaskApplication;

public class CustomerDao {
	public Customer create(Customer customer) {
		Transaction transaction = null;
		
		try (Session session = jTaskApplication.openSession()) {
			session.beginTransaction();
			session.save(customer);
			jTaskApplication.closeSession(session);
			System.out.println("-> Creation successful. Customer Id: " + customer.getCustomerId());
			return customer;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return null;
		}
	}

	public List<Customer> getCustomers() {
		try (Session session = jTaskApplication.openSession()) {
			List<Customer> customers =session.createQuery("from Customer", Customer.class).list(); 
			System.out.println("-> Customers received.");
			return customers;
		}
	}
	
	public void listCustomers() {
		Transaction transaction = null;
		try (Session session = jTaskApplication.openSession()) {
			try {
				transaction = session.beginTransaction();
				List customers = session.createQuery("FROM Customer").list();
				for (Iterator iterator = customers.iterator(); iterator.hasNext();) {
					Customer customer = (Customer) iterator.next();
					System.out.print("--> Id: " + customer.getCustomerId());
					System.out.print(" Name: " + customer.getCustomerName());
					System.out.println(" Surname: " + customer.getCustomerSurname());
				}
				transaction.commit();
			} catch (HibernateException e) {
				if (transaction != null)
					transaction.rollback();
				e.printStackTrace();
			} finally {
				jTaskApplication.closeSession(session);
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	   
	public Customer update(long customerId, String name, String surname) {

		Transaction transaction = null;
		try (Session session = jTaskApplication.openSession()) {
			try {
				transaction = session.beginTransaction();
				Customer customer = (Customer) session.get(Customer.class, customerId);
				customer.setCustomerName(name);
				customer.setCustomerSurname(surname);
				session.update(customer);
				jTaskApplication.closeSession(session);
				System.out.println("-> Update successful. Customer Id: " + customerId);
				return customer;
			} catch (HibernateException e) {
				if (transaction != null)
					transaction.rollback();
				e.printStackTrace();
				return null;
			} finally {
				session.close();
			}
		}
	}
	   
	public void delete(long customerId) {

		Transaction transaction = null;
		try (Session session = jTaskApplication.openSession()) {
			try {
				transaction = session.beginTransaction();
				Customer customer = (Customer) session.get(Customer.class, customerId);
				session.delete(customer);
				jTaskApplication.closeSession(session);
				System.out.println("-> Deletion successful. Customer Id: " + customerId);
			} catch (HibernateException e) {
				if (transaction != null)
					transaction.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}

