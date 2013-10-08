package com.epam.lab.buyit.controller.service.user;

import java.util.List;

import com.epam.lab.buyit.controller.dao.address.AddressDAO;
import com.epam.lab.buyit.controller.dao.contact.ContactDAO;
import com.epam.lab.buyit.controller.dao.user.UserDAO;
import com.epam.lab.buyit.model.Address;
import com.epam.lab.buyit.model.Contact;
import com.epam.lab.buyit.model.User;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;
	private ContactDAO contactDAO;
	private AddressDAO addressDAO;

	public UserServiceImpl() {
		userDAO = new UserDAO();
		contactDAO = new ContactDAO();
		addressDAO = new AddressDAO();
	}

	@Override
	public User getItemById(int id) {
		User user = userDAO.getElementById(id);
		configUser(user);
		return user;
	}

	@Override
	public List<User> getAllItems() {
		List<User> users = userDAO.getAllUsers();
		List<Contact> contacts = contactDAO.getAllContacts();
		List<Address> address = addressDAO.getAllAddress();
		for (User currentUser : users) {
			setUserContact(currentUser, contacts, address);
		}
		return users;
	}

	@Override
	public User createItem(User item) {
		int generated_user_id = userDAO.createElement(item);
		item.setIdUser(generated_user_id);

		Contact contact = item.getContact();
		contact.setUserId(generated_user_id);
		int generated_contact_id = contactDAO.createElement(contact);

		Address address = contact.getAddress();
		address.setContactId(generated_contact_id);
		addressDAO.createElement(address);

		return item;
	}

	@Override
	public User updateItem(User item) {
		userDAO.updateElement(item);

		Contact contact = item.getContact();
		contactDAO.updateElement(contact);

		Address address = contact.getAddress();
		addressDAO.updateElement(address);

		return item;
	}

	@Override
	public User getUser(String login, String password) {
		User user = userDAO.getUser(login, password);
		configUser(user);
		return user;
	}

	@Override
	public boolean checkLogin(String login) {
		return userDAO.checkLogin(login);
	}

	private void setUserContact(User currentUser, List<Contact> contacts,
			List<Address> address) {
		for (Contact currentContact : contacts)
			if (currentContact.getUserId() == currentUser.getIdUser()) {
				currentUser.setContact(currentContact);
				setContactAddress(currentContact, address);
				break;
			}
		return;
	}

	private void setContactAddress(Contact currentContact, List<Address> address) {
		for (Address currentAddress : address)
			if (currentAddress.getContactId() == currentContact.getIdContact()) {
				currentContact.setAddress(currentAddress);
				break;
			}
		return;
	}

	private void configUser(User user) {
		if (user != null) {
			Contact contact = contactDAO.getElementById(user.getIdUser());
			user.setContact(contact);
			contact.setAddress(addressDAO.getElementById(contact.getIdContact()));
		}
	}
}
