package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.service.auction.AuctionServiceImp;
import com.epam.lab.buyit.controller.service.bid.BidServiceImp;
import com.epam.lab.buyit.model.Auction;
import com.epam.lab.buyit.model.Bid;
import com.epam.lab.buyit.model.User;

public class BuyItServeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		User user = (User) request.getSession(false).getAttribute("user");

		AuctionServiceImp auctionService = new AuctionServiceImp();
		BidServiceImp bidService = new BidServiceImp();
		Auction auction = auctionService.getByProductId(idProduct);
		int realCount = auction.getCount();
		String status = null;

		if (auction.getStatus().equals("inProgress")) {
			if (realCount < count) {
				response.sendRedirect("cfxgc");
			} else if (realCount - count == 0) {
				status = "closed";
			} else {
				status = "inProgress";
			}
			int affectedRows = auctionService.buyItServe(
					auction.getIdAuction(), realCount - count, status,
					realCount, auction.getStatus());
			if (affectedRows == 1) {
				Bid bid = new Bid();
				bid.setTime(new Timestamp(System.currentTimeMillis()));
				bid.setAmount(auction.getBuyItNow());
				bid.setAuctionId(auction.getIdAuction());
				bid.setUserId(user.getIdUser());
				bidService.createItem(bid);
				response.sendRedirect("homePageServlet");
			} else {
				request.setAttribute("message", "Sorry, some error with query.");
				request.setAttribute("alert", "error");
				request.getRequestDispatcher("message_page").forward(request, response);
			}

		} else {
			request.setAttribute("message", "Sorry, this auction allready closed.");
			request.setAttribute("alert", "block");
			request.getRequestDispatcher("message_page").forward(request, response);
		}
	}
}
