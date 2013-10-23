package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("userAddProduct");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ProductServiceImpl productService = new ProductServiceImpl();
//		Map<String, String[]> inputValues = request
//				.getParameterMap();
//		
//		Product product = new ProductCreator().create(inputValues);
//		int id = productService.createItem(product).getIdProduct();
//		response.sendRedirect("productDetails?id="+id);
		
		String str = request.getParameter("productName");
		byte ptext[] = str.getBytes();
		String newStr = new String(ptext, "cp1251");
		System.err.println(newStr);
	}

}
