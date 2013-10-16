package com.epam.lab.buyit.controller.service.auction;

import java.util.List;

import com.epam.lab.buyit.controller.dao.auction.AuctionDAO;
import com.epam.lab.buyit.model.Auction;

public class AuctionServiceImp implements AuctionService {
	private AuctionDAO auctionDAO;

	public AuctionServiceImp() {
		auctionDAO = new AuctionDAO();
	}

	@Override
	public Auction getItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auction> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Auction createItem(Auction item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Auction updateItem(Auction item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Auction getByProductId(int id) {
		return auctionDAO.getByProductId(id);
	}

	@Override
	public List<Auction> getLatestAuctions(int number) {
		return auctionDAO.getLatestAuctions(number);
	}

	@Override
	public List<Auction> getSoonEndingAuctions(long currentTime, long endTime) {
		return auctionDAO.getSoonEndingAuctions(currentTime, endTime);
	}

	@Override
	public void closeAuction(int auctionId) {
		auctionDAO.closeAuction(auctionId);

	}

	@Override
	public int buyItServe(int id, int count, String status, int oldCount,
			String oldStatus) {
		return auctionDAO.buyItServe(id, count, status, oldCount, oldStatus);
	}
}
