package com.epam.lab.buyit.controller.dao.bid;

import java.util.List;

import com.epam.lab.buyit.controller.dao.GenericDAO;
import com.epam.lab.buyit.model.Bid;

public interface BidDAOInterface extends GenericDAO<Bid> {
	List<Bid> getByAuctionId(int auctionId);

	List<Bid> getByUserId(int userId);

	List<Bid> getAllBids();

	Bid getUserBid(int userId, int auctionId);

	int getWinUserIdByAuctionId(int id);
}
