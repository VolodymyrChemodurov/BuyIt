package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.service.auction.AuctionServiceImp;
import com.epam.lab.buyit.model.Auction;

public class BuyItServeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int idProduct = Integer.parseInt(request.getParameter("id_product"));
		int count = Integer.parseInt(request.getParameter("count"));

		AuctionServiceImp auctionService = new AuctionServiceImp();
		Auction auction = auctionService.getByProductId(idProduct);
		int realCount = auction.getCount();
		String status = null;

		if (auction.getStatus().equals("inProgress")) {
			if (realCount < count) {
				response.sendRedirect("cfxgc");
			} else if (auction.getCount() - count == 0) {
				status = "closed";
			} else {
				status = "inProgress";
			}
			int affectedRows = auctionService.buyItServe(
					auction.getIdAuction(), realCount - count, status,
					realCount, auction.getStatus());
			if (affectedRows == 1) {
				response.sendRedirect("homePageServlet");
			} else {
				response.sendRedirect("cfxgc");
			}

		}
	}

}
