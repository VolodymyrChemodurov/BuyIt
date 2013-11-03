package com.epam.lab.buyit.test.controller.dao.address;

import java.util.List;

import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.lab.buyit.controller.dao.address.AddressDAO;
import com.epam.lab.buyit.controller.dao.contact.ContactDAO;
import com.epam.lab.buyit.model.Address;
import com.epam.lab.buyit.model.Contact;

public class TestAddressDAO extends Assert {

	private static AddressDAO addressDAO;
	private static Address address;
	private static int id;
	private static int contactId;

	@BeforeClass
	public static void setUpContactDAO() throws NamingException {
		addressDAO = new AddressDAO();
		address = new Address();

		ContactDAO contactDAO = new ContactDAO();
		Contact contact = new Contact();
		contact.setAddress(null).setEmail("1@gmail.com").setPhone("0636534344");

		contactId = contactDAO.createElement(contact);

		address.setCity("Lviv").setFlat("45").setHouse("3")
				.setRegion("Lvivska").setStreet("V.Velykoho")
				.setZipCode("06545").setContactId(contactId);
	}

	@AfterClass
	public static void removeContactDAO() {
		addressDAO = null;
		address = null;
	}

	@Test
	public void testCreateAdrress() {
		id = addressDAO.createElement(address);
		assertNotEquals("Must be not zero", 0, id);
	}

	@Test
	public void testGetElementById() {
		Address desiredAddress = addressDAO.getElementById(id);
		assertNotNull("Must be not NULL", desiredAddress);
	}

	@Test
	public void testUpdateElement() {
		address.setStreet("Bandery").setHouse("12").setFlat("1");
		addressDAO.updateElement(address);
		assertEquals("Bandery", address.getStreet());
	}

	@Test
	public void testGetAllAddress() {
		List<Address> addressList = addressDAO.getAllAddress();
		assertNotNull("Not NULL", addressList);
	}

	@Test
	public void testElementByUserId() {
		Address desiredAddress = addressDAO.getElementByUserId(contactId);
		assertNotNull("Must be not NULL", desiredAddress);
	}

}
