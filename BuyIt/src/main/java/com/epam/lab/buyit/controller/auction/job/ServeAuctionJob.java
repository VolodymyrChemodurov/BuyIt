package com.epam.lab.buyit.controller.auction.job;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.epam.lab.buyit.controller.email.EmailMessageBuilder;
import com.epam.lab.buyit.controller.service.auction.AuctionServiceImp;
import com.epam.lab.buyit.controller.service.bid.BidServiceImp;
import com.epam.lab.buyit.controller.service.product.ProductServiceImpl;
import com.epam.lab.buyit.controller.service.user.UserServiceImpl;
import com.epam.lab.buyit.model.Auction;
import com.epam.lab.buyit.model.Product;
import com.epam.lab.buyit.model.User;

public class ServeAuctionJob implements Job {

	private static final Logger LOGGER = Logger
			.getLogger(ServeAuctionJob.class);
	private AuctionServiceImp auctionService;
	private ProductServiceImpl productService;
	private UserServiceImpl userService;
	private BidServiceImp bidService;
	private EmailMessageBuilder emailMessageBuilder;

	public ServeAuctionJob() {
		auctionService = new AuctionServiceImp();
		productService = new ProductServiceImpl();
		userService = new UserServiceImpl();
		bidService = new BidServiceImp();
		emailMessageBuilder = new EmailMessageBuilder();
	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		int auctionId = (int) arg0.getTrigger().getJobDataMap()
				.get("auctionId");
		LOGGER.info("Serving auction with id = " + auctionId);
		Auction auction = auctionService.getItemById(auctionId);
		if (auction.getStatus().equalsIgnoreCase("inProgress")) {
			auctionService.closeAuction(auctionId);
			Product product = productService
					.getItemById(auction.getProductId());
			User seller = userService.getItemById(product.getUserId());
			User buyer = userService.getItemById(bidService
					.getWinUserIdByAuctionId(auctionId));
			if (buyer != null) {
				emailMessageBuilder.sendWinLotForm(buyer, product, seller);
				emailMessageBuilder.sendProductSoldOnAuctionForm(seller,
						product, buyer);
			} else {
				emailMessageBuilder.sendNoBodyBuyYourProductForm(seller,
						product);
			}
			LOGGER.info("Serve auction with id = " + auctionId);
		}
	}
}