package com.epam.lab.buyit.controller.service.auction;

import java.util.List;

import com.epam.lab.buyit.controller.exception.AuctionAllreadyClosedException;
import com.epam.lab.buyit.controller.exception.BidAmountException;
import com.epam.lab.buyit.controller.exception.WrongProductCountException;
import com.epam.lab.buyit.controller.service.GenericService;
import com.epam.lab.buyit.model.Auction;

public interface AuctionService extends GenericService<Auction> {

	Auction getByProductId(int id);

	List<Auction> getLatestAuctions(int number);

	List<Auction> getSoonEndingAuctions(long currentTime, long endTime);

	void closeAuction(int auctionId);

	boolean buyItServe(int id, int count)
			throws AuctionAllreadyClosedException, WrongProductCountException;
	
	int placeBidServe(int idProduct, double bidAmount) throws AuctionAllreadyClosedException, BidAmountException;
}
