package com.epam.lab.controller.dao;

public interface GenericDAO<T> {
	T getById(int id);

	void insert(T object);

	void update(T object);

	void remove(T object);
}
