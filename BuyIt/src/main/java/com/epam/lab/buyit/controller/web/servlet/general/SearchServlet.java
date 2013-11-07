package com.epam.lab.buyit.controller.web.servlet.general;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.service.search.SearchService;
import com.epam.lab.buyit.controller.service.search.SearchServiceImpl;

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SearchService serviceImpl = null;

	@Override
	public void init() throws ServletException {
		super.init();
		serviceImpl = new SearchServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		serviceImpl.search(request, response);
	}

}
