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
		if(user != null) {
			Contact contact = contactDAO.getElementById(user.getIdUser());
			user.setContact(contact);
			contact.setAddress(addressDAO.getElementById(contact.getIdContact()));
		}
		return user;
	}

	@Override
	public List<User> getAllItems() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verifyUser(String login, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUser(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
