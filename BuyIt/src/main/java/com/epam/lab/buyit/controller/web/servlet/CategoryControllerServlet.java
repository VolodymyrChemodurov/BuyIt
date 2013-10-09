package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.service.subcategory.SubCategoryServiceImpl;
import com.epam.lab.buyit.model.SubCategory;

public class CategoryControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int ITEMS_ON_PAGE = 2;
	private SubCategoryServiceImpl service;

	public void init() {
		service = new SubCategoryServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int number = Integer.parseInt(request.getParameter("number"));
		int page = Integer.parseInt(request.getParameter("page"));
		String way = request.getParameter("way");
		int subCategory_id = Integer.parseInt(request.getParameter("id"));
		SubCategory subCategory = service.getItemById(subCategory_id);
		
		int onPage = setCountItemsOnPage(subCategory);
		int productsCount = subCategory.getProducts().size();
		
		if (way.equals("prev")) {
			number -= onPage;
			page -= 1;
		} else {
			number += onPage;
			page += 1;
		}
		if(number >= productsCount) {
			number = 0;
			page = 1;
		}
		else if(number < 0) { 
			number = productsCount - onPage;
			page = productsCount/onPage;
		}
		
		request.setAttribute("onPage", onPage);
		request.setAttribute("page", page);
		request.setAttribute("number", number);
		request.setAttribute("subCategory", subCategory);
		request.getRequestDispatcher("category").forward(request, response);
	}

	private int setCountItemsOnPage(SubCategory subCategory) {
		if(subCategory.getProducts().size() < ITEMS_ON_PAGE)
			return subCategory.getProducts().size();
		else 
			return ITEMS_ON_PAGE;
	}
	
}
