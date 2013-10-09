package com.epam.lab.buyit.controller.dao;

public interface GenericDAO<T> {

	int createElement(T elem);

	T getElementById(int id);

	void updateElement(T elem);

	void deleteElementById(int id);

}