package jtaskProjects;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import entities.Customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class jTaskApplication {
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		sessionFactory = new Configuration()
				.configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Kayıt ettirme işlemi
//		Customer cust = new Customer(123,"1","1");
//		session.save(cust);

		//get ile alıyoruz
//		int id = 2;
//		Customer getCust = null;
//		getCust = session.get(Customer.class, id);
//		System.out.println(getCust.toString());
		
//		// update işlemi yaptık
//		getCust.setCustomerName("Güncellenmiş name");
//		session.saveOrUpdate(getCust);
		
		//silme
		// session.delete(getCust);


		//listeleme
		List customers = session.createQuery("FROM Customer").list();
		for (Iterator iterator = customers.iterator(); iterator.hasNext();) {
			Customer customer = (Customer) iterator.next();
			System.out.print("Id: " + customer.getCustomerId() + "\n");
		}
		
		session.getTransaction().commit();
		session.close();
		
		
		
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void setSessionFactory(SessionFactory sessionFactory) {
		jTaskApplication.sessionFactory = sessionFactory;
	}

	public static Session openSession() {
		sessionFactory = new Configuration()
				.configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		return session;
	}
	public static void closeSession(Session session) {
		session.getTransaction().commit();
		session.close();
	}

}
