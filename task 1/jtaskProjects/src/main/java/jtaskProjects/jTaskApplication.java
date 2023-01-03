package jtaskProjects;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import entities.Customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class jTaskApplication {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = new Configuration()
				.configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Kayıt ettirme işlemi
//		Customer cust = new Customer(123,"1","1");
//		session.save(cust);

		//get ile alıyoruz
		int id = 2;
		Customer getCust = null;
		getCust = session.get(Customer.class, id);
		System.out.println(getCust.toString());
		
//		// update işlemi yaptık
//		getCust.setCustomerName("Güncellenmiş name");
//		session.saveOrUpdate(getCust);
		
		//silme
		// session.delete(getCust);
		
		System.out.println(session.createCriteria(Customer.class).list());
		
		
		session.getTransaction().commit();
		session.close();
		
		
		
		
		
		
		
		
//		
//		// Prep Work
//				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//				Session session = sessionFactory.openSession();
//				Transaction tx = session.beginTransaction();
//				Employee emp = (Employee) session.load(Employee.class, new Long(101));
//				System.out.println("Employee object loaded. " + emp);
//				tx.commit();
//
//				// update example
//				emp.setName("Updated name");
//				emp.getAddress().setCity("Bangalore");
//				Transaction tx7 = session.beginTransaction();
//				session.update(emp);
//				emp.setName("Final updated name");
//				System.out.println("13. Before committing update transaction");
//				tx7.commit();
//				System.out.println("14. After committing update transaction");
//
//				// Close resources
//				sessionFactory.close();
		
	}

}
