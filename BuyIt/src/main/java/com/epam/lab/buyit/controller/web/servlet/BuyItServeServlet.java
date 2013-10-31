package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.builder.BidBuilder;
import com.epam.lab.buyit.controller.email.EmailMessageBuilder;
import com.epam.lab.buyit.controller.exception.AuctionAllreadyClosedException;
import com.epam.lab.buyit.controller.exception.ParticipationInOwnAuctionException;
import com.epam.lab.buyit.controller.exception.WrongProductCountException;
import com.epam.lab.buyit.controller.service.auction.AuctionServiceImp;
import com.epam.lab.buyit.controller.service.bid.BidServiceImp;
import com.epam.lab.buyit.controller.service.product.ProductServiceImpl;
import com.epam.lab.buyit.controller.service.user.UserServiceImpl;
import com.epam.lab.buyit.model.Auction;
import com.epam.lab.buyit.model.Bid;
import com.epam.lab.buyit.model.Product;
import com.epam.lab.buyit.model.User;

public class BuyItServeServlet extends HttpServlet {
	private static Logger LOGGER = Logger.getLogger(BuyItServeServlet.class);
	private static final long serialVersionUID = 1L;
	private AuctionServiceImp auctionService;
	private BidServiceImp bidService;
	private ProductServiceImpl productService;
	private UserServiceImpl userService;
	private EmailMessageBuilder emailMessageBuilder;

	public void init() {
		auctionService = new AuctionServiceImp();
		bidService = new BidServiceImp();
		productService = new ProductServiceImpl();
		userService = new UserServiceImpl();
		emailMessageBuilder = new EmailMessageBuilder();
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
				int realCount = auctionService.getByProductId(idProduct)
						.getCount();
				if (realCount == 0 || realCount < count) {
					LOGGER.warn("Buy It query was failed");
					request.setAttribute("queryFail",
							"Sorry, someone ahead you");
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
		} catch (ParticipationInOwnAuctionException e) {
			LOGGER.warn(e);
			request.setAttribute("participateInOwnAuction",
					"You can't buy own product");
		} finally {
			request.getRequestDispatcher("deal_information").forward(request,
					response);
		}
	}

	private boolean successServe(int idProduct, int count,
			HttpServletRequest request) throws AuctionAllreadyClosedException,
			WrongProductCountException, ParticipationInOwnAuctionException {
		boolean result = false;
		if (auctionService.buyItServe(idProduct, count)) {
			Product product = productService.getItemById(idProduct);
			User user = (User) request.getSession(false).getAttribute("user");
			if (product.getUserId() == user.getIdUser())
				throw new ParticipationInOwnAuctionException(
						"Try to participate in own auction");
			Auction auction = auctionService.getByProductId(idProduct);
			User seller = userService.getItemById(product.getUserId());
			User buyer = (User) request.getSession(false).getAttribute("user");
			Bid newBid = BidBuilder.build(auction.getIdAuction(),
					buyer.getIdUser(), auction.getBuyItNow());
			Bid bid = bidService.getUserBid(buyer.getIdUser(),
					auction.getIdAuction());
			if (bid == null) {
				bidService.createItem(newBid);
			} else {
				bid.setAmount(auction.getBuyItNow());
				bid.setTime(new Timestamp(System.currentTimeMillis()));
				bidService.updateItem(bid);
			}
			emailMessageBuilder.sendProductSoldOnBuyItNowForm(seller, product,
					buyer, count);
			emailMessageBuilder.sendBuyItNowForm(seller, product, buyer, count);
			request.setAttribute("product", product);
			request.setAttribute("actionMessage", "You bought");
			request.setAttribute("bidAmount", newBid.getAmount());
			request.setAttribute("count", count);
			LOGGER.info("Successful purchase");
			result = true;
		}
		return result;
	}
}
