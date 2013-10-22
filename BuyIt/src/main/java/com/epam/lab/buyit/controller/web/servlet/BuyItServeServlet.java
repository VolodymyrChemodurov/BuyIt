package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.builder.BidBuilder;
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
			if (!successServe(idProduct, count, request)) {
				int realCount = auctionService.getByProductId(idProduct).getCount();
				if (realCount == 0 || realCount < count) {
					LOGGER.warn("Buy It query was failed");
					request.setAttribute("queryFail", "Sorry, someone ahead you");
				} else {
					successServe(idProduct, realCount, request);
				}
			}
		} catch (AuctionAllreadyClosedException e) {
			LOGGER.warn(e);
			request.setAttribute("auctionCloseException", true);
		} catch (WrongProductCountException e) {
			LOGGER.warn(e);
			request.setAttribute("wrongCountException", true);
		} finally {
			request.getRequestDispatcher("deal_information").forward(request, response);
		}
	}

	private boolean successServe(int idProduct, int count,
			HttpServletRequest request) throws AuctionAllreadyClosedException, WrongProductCountException {
		boolean result = false;
		if (auctionService.buyItServe(idProduct, count)) {
			LOGGER.info("Successful purchase");
			Auction auction = auctionService.getByProductId(idProduct);
			User user = (User) request.getSession(false).getAttribute("user");
			Bid bid = BidBuilder.build(auction.getIdAuction(), user.getIdUser(), auction.getBuyItNow());
			bidService.createItem(bid);

			request.setAttribute("product",productService.getItemById(idProduct));
			request.setAttribute("actionMessage", "You bought");
			request.setAttribute("bidAmount", bid.getAmount());
			request.setAttribute("count", count);
			result = true;
			return result;
		} else {
			return result;
		}
	}

}
