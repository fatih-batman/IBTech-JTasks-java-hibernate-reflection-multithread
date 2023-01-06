package operations;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.*;
import jtaskProjects.jTaskApplication;

public class PhoneOperations {
	public void create(Phone phone) {
		Transaction transaction = null;
		try (Session session = jTaskApplication.openSession()) {
			transaction = session.beginTransaction();
			session.save(phone);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Phone> getPhones() {
		try (Session session = jTaskApplication.openSession()) {
			return session.createQuery("from phone", Phone.class).list();
		}
	}
	
	public void list() {
		Transaction transaction = null;
		try (Session session = jTaskApplication.openSession()) {
			try {
				transaction = session.beginTransaction();
				List customers = session.createQuery("FROM phone").list();
				for (Iterator iterator = customers.iterator(); iterator.hasNext();) {
					Phone phone = (Phone) iterator.next();
					System.out.print("Id " + phone.getPhoneId());
					System.out.print(" Country Code " + phone.getCountryNumber());
					System.out.println(" Number " + phone.getPhoneNumber());
				}
				transaction.commit();
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
	
	   
	public void update(long phoneId, String countryCode, String number) {

		Transaction transaction = null;
		try (Session session = jTaskApplication.openSession()) {
			try {
				transaction = session.beginTransaction();
				Phone phone = (Phone) session.get(Phone.class, phoneId);
				phone.setCountryNumber(countryCode);
				phone.setPhoneNumber(number);
				session.update(phone);
				transaction.commit();
			} catch (HibernateException e) {
				if (transaction != null)
					transaction.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		}

	}
	   
	public void delete(long phoneId) {

		Transaction transaction = null;
		try (Session session = jTaskApplication.openSession()) {
			try {
				transaction = session.beginTransaction();
				Phone employee = (Phone) session.get(Phone.class, phoneId);
				session.delete(employee);
				transaction.commit();
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

