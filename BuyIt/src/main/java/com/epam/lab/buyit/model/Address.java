package com.epam.lab.buyit.model;

public class Address {

	private int idAddress;
	private int contactId;
	private String region;
	private String city;
	private String street;
	private String house;
	private String zipCode;

	public int getIdAddress() {
		return idAddress;
	}

	public Address setIdAddress(int idAddress) {
		this.idAddress = idAddress;
		return this;
	}

	public int getContactId() {
		return contactId;
	}

	public Address setContactId(int contactId) {
		this.contactId = contactId;
		return this;
	}

	public String getRegion() {
		return region;
	}

	public Address setRegion(String region) {
		this.region = region;
		return this;
	}

	public String getCity() {
		return city;
	}

	public Address setCity(String city) {
		this.city = city;
		return this;
	}

	public String getStreet() {
		return street;
	}

	public Address setStreet(String street) {
		this.street = street;
		return this;
	}

	public String getHouse() {
		return house;
	}

	public Address setHouse(String house) {
		this.house = house;
		return this;
	}

	public String getZipCode() {
		return zipCode;
	}

	public Address setZipCode(String zipCode) {
		this.zipCode = zipCode;
		return this;
	}

}
