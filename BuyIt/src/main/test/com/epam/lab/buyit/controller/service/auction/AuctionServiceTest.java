package com.epam.lab.buyit.controller.service.auction;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.epam.lab.buyit.controller.Creator;
import com.epam.lab.buyit.controller.dao.auction.AuctionDAO;
import com.epam.lab.buyit.controller.exception.AuctionAllreadyClosedException;
import com.epam.lab.buyit.controller.exception.BidAmountException;
import com.epam.lab.buyit.controller.exception.WrongProductCountException;
import com.epam.lab.buyit.model.Auction;

public class AuctionServiceTest {

	private AuctionServiceImp auctionService = new AuctionServiceImp();
	private AuctionDAO auctionDAO = new AuctionDAO();
	private Creator creator = new Creator();

	@Test
	public void testBuyItServe1() throws AuctionAllreadyClosedException,
			WrongProductCountException {
		int id = creator.createAuction();
		Auction testAuction = auctionService.getItemById(id);
		boolean result = auctionService.buyItServe(testAuction.getProductId(),
				3);
		assertEquals(result, true);
		auctionDAO.deleteElementById(id);
	}

	@Test
	public void testBuyItServe2() throws AuctionAllreadyClosedException,
			WrongProductCountException {
		int id = creator.createAuction();
		Auction testAuction = auctionService.getItemById(id);
		auctionService.buyItServe(testAuction.getProductId(), 5);
		testAuction = auctionService.getItemById(id);
		assertEquals("closed", testAuction.getStatus());
		auctionDAO.deleteElementById(id);
	}

	@Test(expected = WrongProductCountException.class)
	public void testBuyItServe3() throws AuctionAllreadyClosedException,
			WrongProductCountException {
		int id = creator.createAuction();
		Auction testAuction = auctionService.getItemById(id);
		try {
			auctionService.buyItServe(testAuction.getProductId(), 6);
		} finally {
			auctionDAO.deleteElementById(id);
		}
	}

	@Test(expected = AuctionAllreadyClosedException.class)
	public void testBuyItServe4() throws AuctionAllreadyClosedException,
			WrongProductCountException {
		int id = creator.createAuction();
		auctionDAO.closeAuction(id);
		Auction testAuction = auctionDAO.getElementById(id);
		try {
			auctionService.buyItServe(testAuction.getProductId(), 3);
		} finally {
			auctionDAO.deleteElementById(id);
		}
	}

	@Test
	public void testPlaceBidServe1() throws AuctionAllreadyClosedException,
			BidAmountException {
		int id = creator.createAuction();
		Auction auction = auctionService.getItemById(id);
		int result = auctionService.placeBidServe(auction.getProductId(), 60);
		assertEquals(result, id);
		auctionDAO.deleteElementById(id);
	}

	@Test(expected = BidAmountException.class)
	public void testPlaceBidServe2() throws AuctionAllreadyClosedException,
			BidAmountException {
		int id = creator.createAuction();
		Auction auction = auctionService.getItemById(id);
		try {
			auctionService.placeBidServe(auction.getProductId(), 40);
		} finally {
			auctionDAO.deleteElementById(id);
		}
	}
}
