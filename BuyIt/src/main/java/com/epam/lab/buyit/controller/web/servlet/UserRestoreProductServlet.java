package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.creator.ProductCreator;
import com.epam.lab.buyit.controller.service.product.ProductServiceImpl;
import com.epam.lab.buyit.controller.validator.ProductValidation;
import com.epam.lab.buyit.model.Product;

public class UserRestoreProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductServiceImpl productService = new ProductServiceImpl();
		int id = Integer.parseInt(request.getParameter("productId"));
		Product product = productService.getItemById(id);
		request.setAttribute("currentProduct", product);
		request.getRequestDispatcher("userRestoreProductJsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductServiceImpl productService = new ProductServiceImpl();
		request.setCharacterEncoding("utf-8");
		Map<String, String[]> inputValues = request
				.getParameterMap();
		if (ProductValidation.checkingInputValues(inputValues)){
			Product product = new ProductCreator().create(inputValues);
			int id = productService.createItem(product).getIdProduct();
			response.sendRedirect("productDetails?id="+id);
		} response.sendRedirect("userRestoreProduct?productId="+request.getParameter("productId"));
		
	}

}
