package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.creator.ProductCreator;
import com.epam.lab.buyit.controller.service.product.ProductServiceImpl;
import com.epam.lab.buyit.controller.setters.ProductSetter;
import com.epam.lab.buyit.controller.validator.ProductValidation;
import com.epam.lab.buyit.model.Product;

public class UserAddProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("userAddProduct");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ProductServiceImpl productService = new ProductServiceImpl();
		request.setCharacterEncoding("utf-8");
		Map<String, String[]> inputValues = request.getParameterMap();
		if (ProductValidation.checkingInputValues(inputValues)) {
			Product product = new ProductCreator().create(inputValues);
			product = ProductSetter.uploadingImages(product, request);
			int id = productService.createItem(product).getIdProduct();

			response.sendRedirect("productDetails?id=" + id);
		} else {
			response.sendRedirect("userAddProduct");
		}
	}
}
