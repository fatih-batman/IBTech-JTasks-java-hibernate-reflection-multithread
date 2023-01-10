package xmlHelper;

import java.io.StringReader;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import commandExecuter.CommandExecuter;
import dataCarrier.DataCarrier;
import dataCarrier.DataCarrierEnum;
import entities.Customer;


public class xmlHelper {
	
	
	
	public static DataCarrier makeOperations(String body) throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new InputSource(new StringReader(body)));
		document.getDocumentElement().normalize();

		String commandName = document.getDocumentElement().getElementsByTagName("commandName").item(0).getTextContent();
		String customerName = document.getDocumentElement().getElementsByTagName("customerName").item(0)
				.getTextContent();
		String customerSurname = document.getDocumentElement().getElementsByTagName("customerSurname").item(0)
				.getTextContent();

		Customer customer = new Customer(customerName, customerSurname);
		System.out.println(customer.getCustomerName());
		System.out.println(customer.getCustomerSurname());
		
		DataCarrier bag = new DataCarrier();
		bag.put(DataCarrierEnum.NAME, customer.getCustomerName());
		bag.put(DataCarrierEnum.SURNAME, customer.getCustomerSurname());
		CommandExecuter convertedDataCarrier = new CommandExecuter();
		DataCarrier resultBag = convertedDataCarrier.execute(commandName, bag);
		return resultBag;	
		//return bag;
	}

}
