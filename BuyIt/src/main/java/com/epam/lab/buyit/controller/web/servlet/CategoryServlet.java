package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.service.subcategory.SubCategoryServiceImpl;
import com.epam.lab.buyit.model.SubCategory;

public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SubCategoryServiceImpl subCategoryServce;
	
	public void init() {
		subCategoryServce = new SubCategoryServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int subCategory_id = Integer.parseInt(request.getParameter("id"));
		SubCategory subCategory = subCategoryServce.getItemById(subCategory_id);
		request.setAttribute("subCategory", subCategory);
		request.setAttribute("number", 0);
		request.getRequestDispatcher("category").forward(request, response);
	}

}
