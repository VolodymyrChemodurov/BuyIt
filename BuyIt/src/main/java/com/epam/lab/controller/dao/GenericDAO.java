package com.epam.lab.controller.dao;

public interface GenericDAO<T> {

	public T createElement(T elem);

	public T readElementById(int id);

	public T updateElement(T elem);

	public void deleteElementById(int id);

}
