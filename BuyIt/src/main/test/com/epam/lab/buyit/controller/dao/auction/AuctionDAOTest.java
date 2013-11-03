package com.epam.lab.buyit.controller.dao.auction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import com.epam.lab.buyit.controller.Creator;
import com.epam.lab.buyit.model.Auction;

public class AuctionDAOTest {

	private AuctionDAO auctionDAO = new AuctionDAO();
	private Creator creator = new Creator();

	@Test
	public void testCreate() {
		int id = creator.createAuction();
		assertNotNull("Id not null", id);
		auctionDAO.deleteElementById(id);
	}

	@Test
	public void testGetById() {
		int id = creator.createAuction();
		Auction auctionTest = auctionDAO.getElementById(id);
		assertNotNull(auctionTest);
		auctionDAO.deleteElementById(id);
	}

	@Test
	public void testGetByProductId() {
		int id = creator.createAuction();
		Auction auctionTest = auctionDAO.getByProductId(33);
		assertNotNull(auctionTest);
		auctionDAO.deleteElementById(id);
	}

	@Test
	public void testGetLatestAuctions() {
		List<Auction> latestAuctionsTest = auctionDAO.getLatestAuctions(8,
				System.currentTimeMillis());
		assertNotNull(latestAuctionsTest);
	}

	@Test
	public void testGetSoonEndingAuctions() {
		long sixHours = 6 * 60 * 60 * 1000;
		List<Auction> soonEndingAuctionsTest = auctionDAO
				.getSoonEndingAuctions(System.currentTimeMillis(),
						System.currentTimeMillis() + sixHours);
		assertNotNull(soonEndingAuctionsTest);
	}

	@Test
	public void testCloseAuction() {
		int id = creator.createAuction();
		auctionDAO.closeAuction(id);
		Auction auctionTest = auctionDAO.getElementById(id);
		assertNotEquals("inProgress", auctionTest.getStatus());
		auctionDAO.deleteElementById(id);
	}

	@Test
	public void testBuyItServe() {
		int id = creator.createAuction();
		Auction testAuction = auctionDAO.getElementById(id);
		int rows = auctionDAO.buyItServe(id, 0, "closed",
				testAuction.getCount(), testAuction.getStatus());
		assertEquals(1, rows);
		auctionDAO.deleteElementById(id);
	}

	@Test
	public void testBidServe() {
		int id = creator.createAuction();
		Auction testAuction = auctionDAO.getElementById(id);
		int rows = auctionDAO.bidServe(id, 300, testAuction.getCurrentPrice(),
				testAuction.getStatus());
		assertEquals(1, rows);
		auctionDAO.deleteElementById(id);
	}

	@Test
	public void testDelete() {
		int id = creator.createAuction();
		auctionDAO.deleteElementById(id);
		assertNull(auctionDAO.getElementById(id));
	}
}
