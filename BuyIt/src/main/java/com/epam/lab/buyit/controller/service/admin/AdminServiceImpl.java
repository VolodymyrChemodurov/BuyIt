package com.epam.lab.buyit.controller.service.admin;

import java.util.ArrayList;
import java.util.List;

import com.epam.lab.buyit.controller.dao.address.AddressDAO;
import com.epam.lab.buyit.controller.dao.contact.ContactDAO;
import com.epam.lab.buyit.controller.dao.user.UserDAO;
import com.epam.lab.buyit.model.Address;
import com.epam.lab.buyit.model.Contact;
import com.epam.lab.buyit.model.User;

public class AdminServiceImpl implements AdminService {
	private UserDAO userDAO;
	private ContactDAO contactDAO;
	private AddressDAO addressDAO;

	public AdminServiceImpl() {
		userDAO = new UserDAO();
		contactDAO = new ContactDAO();
		addressDAO = new AddressDAO();
	}

	@Override
	public User getItemById(int id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<User> getAllItems() {
		List<User> users = userDAO.getAllUsers();
		List<Contact> contacts = contactDAO.getAllContacts();
		List<Address> address = addressDAO.getAllAddress();
		for (User currentUser : users) {
			setUserContact(currentUser, contacts, address);
		}
		List<User> onlyUsers = getOnlyUsers(users);
		return onlyUsers;
	}

	@Override
	public User createItem(User item) {
		throw new UnsupportedOperationException();
	}

	@Override
	public User updateItem(User item) {
		userDAO.updateElement(item);
		return item;
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

	private List<User> getOnlyUsers(List<User> users) {
		List<User> onlyUsers = new ArrayList<>();
		for (User currentUser : users) {
			if (!currentUser.getRole()) {
				onlyUsers.add(currentUser);
			}
		}
		return onlyUsers;
	}

}
