package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.service.product.ProductServiceImpl;
import com.epam.lab.buyit.controller.setters.ProductSetter;
import com.epam.lab.buyit.model.Product;

public class UserEditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in servlet");
		ProductServiceImpl productService = new ProductServiceImpl();
		int id = Integer.parseInt(request.getParameter("productId"));
		Product product = productService.getItemById(id);
		request.setAttribute("currentProduct", product);
		request.getRequestDispatcher("userEditProductJsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductServiceImpl productService = new ProductServiceImpl();
		Map<String, String[]> inputValues = request
				.getParameterMap();
		Product product = (Product) request.getAttribute("currentProduct");
		product = ProductSetter.setDescriptionFields(product, inputValues);
		productService.updateByProductId(product);
		response.sendRedirect("productDetails?id="+product.getIdProduct());
		
		
	}

}
