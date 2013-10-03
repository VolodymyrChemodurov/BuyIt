package com.epam.lab.buyit.model;

public class Users {

	private int idUser;
	private String status;
	private String firstName;
	private String lastName;
	private String login;
	private String password;

	public int getIdUser() {
		return idUser;
	}

	public Users setIdUser(int idUser) {
		this.idUser = idUser;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public Users setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public Users setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public Users setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getLogin() {
		return login;
	}

	public Users setLogin(String login) {
		this.login = login;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public Users setPassword(String password) {
		this.password = password;
		return this;
	}

}
