package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.service.product.ProductServiceImpl;
import com.epam.lab.buyit.model.Product;
import com.epam.lab.buyit.model.User;

public class UserSalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductServiceImpl productService;

	public void init() {
		productService = new ProductServiceImpl();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		List<Product> productList = productService.getItemsByUserId(user
				.getIdUser());
		List<Product> activeList = new ArrayList<Product>();
		List<Product> endedList = new ArrayList<Product>();
		for (Product current : productList) {
			if (current.getAuction().getStatus().equals("closed")) {
				endedList.add(current);
			} else {
				activeList.add(current);
			}
		}
		request.getSession().setAttribute("userActiveSales", activeList);
		request.getSession().setAttribute("userEndedSales", endedList);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("userSales");
		dispatcher.forward(request, response);

	}

}
