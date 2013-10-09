package com.epam.lab.buyit.controller.service.search;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.service.GenericService;
import com.epam.lab.buyit.model.Product;

public interface SearchService extends GenericService<Product> {
	
	public void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;


}
