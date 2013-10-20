package com.epam.lab.buyit.controller.service.bid;

import java.sql.Timestamp;
import java.util.List;

import com.epam.lab.buyit.controller.builder.BidBuilder;
import com.epam.lab.buyit.controller.dao.bid.BidDAO;
import com.epam.lab.buyit.controller.exception.AuctionAllreadyClosedException;
import com.epam.lab.buyit.controller.exception.BidAmountException;
import com.epam.lab.buyit.controller.service.auction.AuctionService;
import com.epam.lab.buyit.controller.service.auction.AuctionServiceImp;
import com.epam.lab.buyit.model.Bid;

public class BidServiceImp implements BidService {
	private BidDAO bidDAO;
	private AuctionService auctionService;

	public BidServiceImp() {
		bidDAO = new BidDAO();
		auctionService = new AuctionServiceImp();
	}

	@Override
	public Bid getItemById(int id) {
		return bidDAO.getElementById(id);
	}

	@Override
	public List<Bid> getAllItems() {
		return bidDAO.getAllBids();
	}

	@Override
	public Bid createItem(Bid item) {
		int generetedBidId = bidDAO.createElement(item);
		item.setIdBid(generetedBidId);
		return item;
	}

	@Override
	public Bid updateItem(Bid item) {
		bidDAO.updateElement(item);
		return item;
	}

	@Override
	public List<Bid> getByAuctionId(int auctionId) {
		return bidDAO.getByAuctionId(auctionId);
	}

	public Object getItemByUserId(int id) {
		return bidDAO.getByUserId(id);
	}

	@Override
	public boolean serveBid(int userId, int productId, double bidAmount) throws BidAmountException, AuctionAllreadyClosedException{
		int auctionId = 0;
		if((auctionId = auctionService.placeBidServe(productId, bidAmount)) > 0) {
			Bid userBid = bidDAO.getUserBid(userId, auctionId);
			if(userBid != null) {
				userBid.setAmount(bidAmount);
				userBid.setTime(new Timestamp(System.currentTimeMillis()));
				updateItem(userBid);
			} else {
				userBid = BidBuilder.build(auctionId, userId, bidAmount);
				createItem(userBid);
			}
			return true;
		}
		else return false;
		
	}

}
