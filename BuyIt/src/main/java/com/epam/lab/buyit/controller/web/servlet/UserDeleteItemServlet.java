package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.service.product.ProductServiceImpl;
import com.epam.lab.buyit.model.Product;
import com.epam.lab.buyit.model.User;

public class UserDeleteItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductServiceImpl productService;

	public void init() {
		productService = new ProductServiceImpl();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("itemId");
		productService.deleteItemById(Integer.parseInt(id));
		User user = (User) request.getSession().getAttribute("user");
		List<Product> productList = productService.getItemsByUserId(user
				.getIdUser());
		List<Product> endedList = new ArrayList<Product>();
		for (Product current : productList) {
			if (current.getAuction().getStatus().equals("closed")) {
				endedList.add(current);
			}
		}
		request.getSession().setAttribute("userEndedSales", endedList);

	}

}
