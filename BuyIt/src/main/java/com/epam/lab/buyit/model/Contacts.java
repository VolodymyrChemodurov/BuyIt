package com.epam.lab.buyit.model;

public class Contacts {

	private int idContacts;
	private int userId;
	private String email;
	private String phone;
	private int addressId;

	public int getIdContacts() {
		return idContacts;
	}

	public Contacts setIdContacts(int idContacts) {
		this.idContacts = idContacts;
		return this;
	}

	public int getUserId() {
		return userId;
	}

	public Contacts setUserId(int userId) {
		this.userId = userId;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Contacts setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public Contacts setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public int getAddressId() {
		return addressId;
	}

	public Contacts setAddressId(int addressId) {
		this.addressId = addressId;
		return this;
	}

}
