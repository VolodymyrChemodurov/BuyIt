package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.service.bid.BidServiceImp;
import com.epam.lab.buyit.controller.service.product.ProductServiceImpl;
import com.epam.lab.buyit.model.Product;
import com.epam.lab.buyit.model.User;


public class UserShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductServiceImpl productService = new ProductServiceImpl();
		BidServiceImp bidService = new BidServiceImp();
		User user = (User)request.getSession().getAttribute("user");
		List<Product> wonList = productService.getWonItemsByUserId(user.getIdUser());
		List<Product> lostList = productService.getLostItemsByUserId(user.getIdUser());
		List<Product> activeList = productService.getActiveItemsByUserId(user.getIdUser());
		List<Product> buyList = productService.getBuyItemsByUserId(user.getIdUser());
		request.getSession().setAttribute("userActiveShopping", activeList);
		request.getSession().setAttribute("userPurchasedShopping", wonList);
		request.getSession().setAttribute("userLostShopping", lostList);
		request.getSession().setAttribute("userBuyShopping", buyList);
		request.getSession().setAttribute("bids", bidService.getItemByUserId(user.getIdUser()));
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("userShopping");
		dispatcher.forward(request, response);
	}


}
