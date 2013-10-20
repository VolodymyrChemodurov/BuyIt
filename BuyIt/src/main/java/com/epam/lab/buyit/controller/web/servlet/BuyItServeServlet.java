package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.exception.AuctionAllreadyClosedException;
import com.epam.lab.buyit.controller.exception.WrongProductCountException;
import com.epam.lab.buyit.controller.service.auction.AuctionServiceImp;
import com.epam.lab.buyit.controller.service.bid.BidServiceImp;
import com.epam.lab.buyit.controller.service.product.ProductService;
import com.epam.lab.buyit.controller.service.product.ProductServiceImpl;
import com.epam.lab.buyit.model.Auction;
import com.epam.lab.buyit.model.Bid;
import com.epam.lab.buyit.model.User;

public class BuyItServeServlet extends HttpServlet {
	private static Logger LOGGER = Logger.getLogger(BuyItServeServlet.class);
	private static final long serialVersionUID = 1L;
	private AuctionServiceImp auctionService;
	private BidServiceImp bidService;
	private ProductService productService;

	public void init() {
		auctionService = new AuctionServiceImp();
		bidService = new BidServiceImp();
		productService = new ProductServiceImpl();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		serve(request, response);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		serve(request, response);
	}

	private void serve(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		int idProduct = Integer.parseInt(request.getParameter("id_product"));
		int count = Integer.parseInt(request.getParameter("quantity"));

		try {
			if (auctionService.buyItServe(idProduct, count)) {
				successfulPurchase(request, response, count, idProduct);
			} else {
				LOGGER.warn("Buy It qury was fail");
				queryFail(request, response);
			}
		} catch (AuctionAllreadyClosedException e) {
			LOGGER.warn(e);
			auctionAllreadyClosed(request, response);
		} catch (WrongProductCountException e) {
			LOGGER.warn(e);
			wrongProductCount(request, response);
		}
	}

	private void successfulPurchase(HttpServletRequest request,
			HttpServletResponse response, int count, int idProduct) throws ServletException, IOException {
		Auction auction = auctionService.getByProductId(idProduct);
		Bid bid = new Bid();
		bid.setTime(new Timestamp(System.currentTimeMillis()));
		bid.setAmount(auction.getBuyItNow());
		bid.setAuctionId(auction.getIdAuction());
		User user = (User) request.getSession(false).getAttribute("user");
		bid.setUserId(user.getIdUser());
		bidService.createItem(bid);

		request.setAttribute("product", productService.getItemById(idProduct));
		request.setAttribute("user", user);
		request.setAttribute("bid", bid);
		request.setAttribute("count", count);
		request.getRequestDispatcher("deal_information").forward(request,
				response);
	}

	private void queryFail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("message", "Sorry, some error with query.");
		request.setAttribute("alert", "error");
		request.getRequestDispatcher("message_page").forward(request, response);
	}

	private void auctionAllreadyClosed(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("message", "Sorry, this auction allready closed.");
		request.setAttribute("alert", "block");
		request.getRequestDispatcher("message_page").forward(request, response);
	}

	private void wrongProductCount(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("message",
				"Sorry, you count exceeds the existing.");
		request.setAttribute("alert", "block");
		request.getRequestDispatcher("message_page").forward(request, response);
	}
}
