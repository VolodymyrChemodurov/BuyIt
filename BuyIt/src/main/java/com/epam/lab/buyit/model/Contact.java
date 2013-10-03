package com.epam.lab.buyit.model;

public class Contact {

	private int idContacts;
	private int userId;
	private String email;
	private String phone;
	private Address address;

	public int getIdContacts() {
		return idContacts;
	}

	public Contact setIdContacts(int idContacts) {
		this.idContacts = idContacts;
		return this;
	}

	public int getUserId() {
		return userId;
	}

	public Contact setUserId(int userId) {
		this.userId = userId;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Contact setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public Contact setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public Address getAddress() {
		return address;
	}

	public Contact setAddress(Address address) {
		this.address = address;
		return this;
	}

}
