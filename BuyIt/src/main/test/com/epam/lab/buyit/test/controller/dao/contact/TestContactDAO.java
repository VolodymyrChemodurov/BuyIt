package com.epam.lab.buyit.test.controller.dao.contact;

import java.util.List;

import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.lab.buyit.controller.dao.contact.ContactDAO;
import com.epam.lab.buyit.model.Contact;

public class TestContactDAO extends Assert {
	private static ContactDAO contactDAO;
	private static Contact contact;
	private static int id;

	@BeforeClass
	public static void setUpContactDAO() throws NamingException {
		contactDAO = new ContactDAO();
		contact = new Contact();

		contact.setAddress(null).setEmail("root@gmail.com")
				.setPhone("0636544889");
	}

	@AfterClass
	public static void removeContactDAO() {
		contactDAO = null;
		contact = null;
	}

	@Test
	public void testCreateContact() {
		id = contactDAO.createElement(contact);
		assertNotEquals("Must be not zero", 0, id);
	}

	@Test
	public void testGetElementById() {
		Contact desiredContact = contactDAO.getElementById(id);
		assertNotNull("Must be not NULL", desiredContact);
	}

	@Test
	public void testUpdateElement() {
		contact.setEmail("dandy@gmail.com");
		contactDAO.updateElement(contact);
		assertEquals("dandy@gmail.com", contact.getEmail());
	}

	@Test
	public void testGetAllUsers() {
		List<Contact> contactList = contactDAO.getAllContacts();
		assertNotNull("Not NULL", contactList);
	}

}
