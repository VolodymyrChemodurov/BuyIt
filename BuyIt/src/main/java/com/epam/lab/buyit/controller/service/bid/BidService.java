package com.epam.lab.buyit.controller.service.bid;

import java.util.List;

import com.epam.lab.buyit.controller.exception.AuctionAllreadyClosedException;
import com.epam.lab.buyit.controller.exception.BidAmountException;
import com.epam.lab.buyit.controller.service.GenericService;
import com.epam.lab.buyit.model.Bid;

public interface BidService extends GenericService<Bid> {
	List<Bid> getByAuctionId(int auctionid);

	boolean serveBid(int userId, int productId, double bidAmount)
			throws BidAmountException, AuctionAllreadyClosedException;

	int getWinUserIdByAuctionId(int id);
}
