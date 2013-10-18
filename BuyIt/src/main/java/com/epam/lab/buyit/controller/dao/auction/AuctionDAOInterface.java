package com.epam.lab.buyit.controller.dao.auction;

import java.util.List;

import com.epam.lab.buyit.controller.dao.GenericDAO;
import com.epam.lab.buyit.model.Auction;

public interface AuctionDAOInterface extends GenericDAO<Auction> {

	Auction getByProductId(int productId);

	List<Auction> getLatestAuctions(int number);

	List<Auction> getSoonEndingAuctions(long currentTime, long endTime);

	void closeAuction(int id);

	int buyItServe(int id, int count, String status, int oldCount,
			String oldStatus);
}
