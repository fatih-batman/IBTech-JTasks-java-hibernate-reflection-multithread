package operations;

import java.util.Iterator;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.CustomerDao;
import dataCarrier.DataCarrier;
import dataCarrier.DataCarrierEnum;
import entities.*;
import jtaskProjects.jTaskApplication;

public class CustomerOperation {
	
	
	private CustomerDao customerDao;

	public CustomerOperation() {
		this.customerDao = new CustomerDao();
	}

	public DataCarrier add(DataCarrier data) {
		String name = (String) data.getValue(DataCarrierEnum.NAME);
		String surname = (String) data.getValue(DataCarrierEnum.SURNAME);

		Customer customer = new Customer(name, surname);
		Customer createdCustomer = customerDao.create(customer);
		
		DataCarrier createdCustomerData = new DataCarrier();
		createdCustomerData.put(DataCarrierEnum.ID, createdCustomer.getCustomerId());
		createdCustomerData.put(DataCarrierEnum.NAME, createdCustomer.getCustomerName());
		createdCustomerData.put(DataCarrierEnum.SURNAME, createdCustomer.getCustomerSurname());
		
		return createdCustomerData;
	}

	public DataCarrier update(DataCarrier data) {	
		long id = (long) data.getValue(DataCarrierEnum.ID);
		String name = (String) data.getValue(DataCarrierEnum.NAME);
		String surname = (String) data.getValue(DataCarrierEnum.SURNAME);			
		
		Customer customer = customerDao.update(id, name, surname);
		DataCarrier updatedCustomerData = new DataCarrier();
		updatedCustomerData.put(DataCarrierEnum.ID, customer.getCustomerId());
		updatedCustomerData.put(DataCarrierEnum.NAME, customer.getCustomerName());
		updatedCustomerData.put(DataCarrierEnum.SURNAME, customer.getCustomerSurname());
		
		return updatedCustomerData;
	}

	public DataCarrier list() {
		List<Customer> customers = customerDao.getCustomers();
		DataCarrier bag = new DataCarrier();
		bag.put(DataCarrierEnum.CUSTOMERLIST, customers);
		return bag;
	}

	public DataCarrier delete(DataCarrier data) {
		long id = (long) data.getValue(DataCarrierEnum.ID);
		customerDao.delete(id);
		
		DataCarrier deletedCustomerData = new DataCarrier();
		deletedCustomerData.put(DataCarrierEnum.ID, id);
		deletedCustomerData.put(DataCarrierEnum.ISSUCCESSFULL, true);
		deletedCustomerData.put(DataCarrierEnum.MESSAGE, "Success");
		
		return deletedCustomerData;
	}


}


