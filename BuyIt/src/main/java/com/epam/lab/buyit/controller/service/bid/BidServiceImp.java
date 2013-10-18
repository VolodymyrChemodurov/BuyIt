package com.epam.lab.buyit.controller.service.bid;

import java.util.List;

import com.epam.lab.buyit.controller.dao.bid.BidDAO;
import com.epam.lab.buyit.model.Bid;

public class BidServiceImp implements BidService {
	private BidDAO bidDAO;

	public BidServiceImp() {
		bidDAO = new BidDAO();

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

}
