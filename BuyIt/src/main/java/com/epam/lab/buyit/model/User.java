package com.epam.lab.buyit.model;

import java.util.List;

public class User {

	private int idUser;
	private boolean role;
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private Contact contact;
	private int contactsId;
	private List<Product> productList;
	private List<Bid> bidList;

	public int getIdUser() {
		return idUser;
	}

	public User setIdUser(int idUser) {
		this.idUser = idUser;
		return this;
	}

	public boolean getRole() {
		return role;
	}

	public User setRole(boolean role) {
		this.role = role;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public User setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public User setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getLogin() {
		return login;
	}

	public User setLogin(String login) {
		this.login = login;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public Contact getContact() {
		return contact;
	}

	public User setContact(Contact contact) {
		this.contact = contact;
		return this;
	}

	public int getContactsId() {
		return contactsId;
	}

	public User setContactsId(int contactsId) {
		this.contactsId = contactsId;
		return this;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public User setProductList(List<Product> productList) {
		this.productList = productList;
		return this;
	}

	public List<Bid> getBidList() {
		return bidList;
	}

	public User setBidList(List<Bid> bidList) {
		this.bidList = bidList;
		return this;
	}

}
