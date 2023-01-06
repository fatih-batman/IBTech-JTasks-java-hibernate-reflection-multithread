package jtaskProjects;
//import entities.*;
import entities.Command;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import commandExecuter.*;
import dataCarrier.DataCarrier;
import dataCarrier.DataCarrierEnum;

public class jTaskApplicationReflection {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

//		Bag bagAdd = new Bag();
//		bagAdd.put(BagKey.NAME, "Fatih");
//		bagAdd.put(BagKey.SURNAME, "Batman");
//		SessionFactory sessionFactory = new Configuration()
//				.configure()
//				.buildSessionFactory();
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		Command command = new Command(1, "saveCustomer","Customer", "crete");
//		session.save(command);
		
		
		
//		session.getTransaction().commit();
//		session.close();
		
		/*
		 * // Kayıt ettirme işlemi
		 */
		DataCarrier dataCarrier = new DataCarrier();
		dataCarrier.put(DataCarrierEnum.NAME, "Morales");
		dataCarrier.put(DataCarrierEnum.SURNAME, "Ayma");
		dataCarrier.put(DataCarrierEnum.CLASS, "Customer");
		
		DataCarrier customerBag = CommandExecuter.execute("customer_add", dataCarrier);
//		
//		/*
//		 * update işlemi yaptık
//		 */
//		DataCarrier bagUpdate = new DataCarrier();
//		long id = (long) customerBag.getValue(DataCarrierEnum.ID);
//		bagUpdate.put(DataCarrierEnum.ID, id);
//		bagUpdate.put(DataCarrierEnum.NAME, "Updated");
//		bagUpdate.put(DataCarrierEnum.SURNAME, "Ayma");
//
//		DataCarrier updatedBag = CommandExecuter.execute("customer_update", bagUpdate);
//
//		/*
//		 * silme
//		 */
//		DataCarrier bagDelete = new DataCarrier();
//		long customerId = (long) customerBag.getValue(DataCarrierEnum.ID);
//		bagDelete.put(DataCarrierEnum.ID, customerId);
//
//		DataCarrier deletedCustomerBag = CommandExecuter.execute("customer_delete", bagDelete);

		

	}

}
