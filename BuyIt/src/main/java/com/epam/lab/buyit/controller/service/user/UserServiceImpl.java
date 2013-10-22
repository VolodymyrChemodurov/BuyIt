package com.epam.lab.buyit.controller.service.user;

import java.util.ArrayList;
import java.util.List;

import com.epam.lab.buyit.controller.dao.address.AddressDAO;
import com.epam.lab.buyit.controller.dao.contact.ContactDAO;
import com.epam.lab.buyit.controller.dao.user.UserDAO;
import com.epam.lab.buyit.controller.security.MD5Encryptor;
import com.epam.lab.buyit.controller.service.bid.BidServiceImp;
import com.epam.lab.buyit.model.Address;
import com.epam.lab.buyit.model.Bid;
import com.epam.lab.buyit.model.Contact;
import com.epam.lab.buyit.model.User;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;
	private ContactDAO contactDAO;
	private AddressDAO addressDAO;
	private BidServiceImp bidService;

	public UserServiceImpl() {
		userDAO = new UserDAO();
		contactDAO = new ContactDAO();
		addressDAO = new AddressDAO();
		bidService = new BidServiceImp();
	}

	@Override
	public void setBann(String id) {
			int tmpId = Integer.parseInt(id);
			User currentUser = userDAO.getElementById(tmpId);
			currentUser.setBan(true);
			userDAO.updateElement(currentUser);
	}

	@Override
	public void setUnbann(String id) {
			int tmpId = Integer.parseInt(id);
			User currentUser = userDAO.getElementById(tmpId);
			currentUser.setBan(false);
			userDAO.updateElement(currentUser);
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
		User user = userDAO.getUser(login, MD5Encryptor.encrypt(password));
		configUser(user);
		return user;
	}

	@Override
	public boolean checkLogin(String login) {
		return userDAO.checkLogin(login);
	}
	
	public boolean checkPassword(String login, String password) {
		boolean checkResult = false;
		if (getUser(login, password)== null){
			checkResult = true;
		}
		return checkResult;
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
			contact.setAddress(addressDAO.getElementByUserId(contact.getIdContact()));
		}
	}

	@Override
	public List<User> getWhoMakeBidInAuction(int auctionId) {
		List<Bid> bidList = new ArrayList<Bid>();
		List<User> userList = new ArrayList<User>();
		
		bidList = bidService.getByAuctionId(auctionId);
		User currentUser = null;
		for (Bid bid : bidList) {
			currentUser = userDAO.getElementById(bid.getUserId());
			currentUser.setBidList(new ArrayList<Bid>());
			currentUser.getBidList().add(bid);
			
			userList.add(currentUser);
			
		}
		return userList;
	}
}
