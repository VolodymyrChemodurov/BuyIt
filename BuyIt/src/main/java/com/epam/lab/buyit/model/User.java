package com.epam.lab.buyit.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idUser;
	private boolean role;
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private Contact contact;
	private String avatar;
	private Status ban;
	private List<Product> productList;
	private List<Bid> bidList;

	public User() {
		contact = new Contact();
	}

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

	public String getAvatar() {
		return avatar;
	}

	public User setAvatar(String avatar) {
		this.avatar = avatar;
		return this;
	}

	public String getBan() {
		return ban.getStatus();
	}

	public User setBan(boolean ban) {
		this.ban = Status.geRoleByType(ban);
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

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(idUser).append(" role: ")
				.append(role ? " Admin" : " User").append(" first name: ")
				.append(firstName).append(" last name: ").append(lastName)
				.append(" login: ").append(login).append(" password: ")
				.append(password);
		return string.toString();
	}

}
