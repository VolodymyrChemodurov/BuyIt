package com.epam.lab.buyit.model;

import java.util.List;

public class User {

	private int idUser;
	private boolean status;
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private Contact contact;
	private List<Product> productList;
	private List<Bid> bidList;

	public int getIdUser() {
		return idUser;
	}

	public User setIdUser(int idUser) {
		this.idUser = idUser;
		return this;
	}

	public boolean getStatus() {
		return status;
	}

	public User setStatus(boolean status) {
		this.status = status;
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

	public Contact getContacts() {
		return contact;
	}

	public User setContacts(Contact contact) {
		this.contact = contact;
		return this;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
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
