package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.service.subcategory.SubCategoryServiceImpl;
import com.epam.lab.buyit.model.SubCategory;
import com.google.gson.Gson;

public class SubCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SubCategoryServiceImpl subService;

	public void init() {
		subService = new SubCategoryServiceImpl();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id_string = request.getParameter("categoryId");
		int id = Integer.parseInt(id_string);
		List<SubCategory> subList = subService.getAllItemsByCategoryId(id);
		String data = new Gson().toJson(subList);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(data);
	}

}
