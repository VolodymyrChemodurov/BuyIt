package com.epam.lab.buyit.controller.service;

import java.util.List;

public interface GenericService<T> {

	T getItemById(int id);
	
	List<T> getAllItems();
	
	T createItem(T item);
	
	T updateItem(T item);
}
