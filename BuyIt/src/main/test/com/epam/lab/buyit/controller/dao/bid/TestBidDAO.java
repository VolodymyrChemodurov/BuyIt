package com.epam.lab.buyit.controller.dao.bid;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.lab.buyit.controller.dao.bid.BidDAO;
import com.epam.lab.buyit.model.Bid;


public class TestBidDAO {
	private static BidDAO bidDAO = null;

	private static Bid bid = null;
	private static Bid newBid = null;
	
	@BeforeClass
	public static void setUPBeforeClass(){
		bidDAO = new BidDAO();
	
		
		bid = new Bid();
		bid.setAmount(1);
		bid.setAuctionId(1);
		bid.setUserId(1);
		bid.setTime(new Timestamp(new Date().getTime()));
		
		newBid = new Bid();
		newBid.setAmount(2);
		newBid.setAuctionId(2);
		newBid.setUserId(2);
		newBid.setTime(new Timestamp(new Date().getTime()));
		
		   
	}

	@Test
	public void testCreateElement() throws Exception {
		
		int id = bidDAO.createElement(bid);
		assertNotNull("Id not null", id);
	}
	
	
	@Test 
	public void testGetElementById() throws Exception{
		int id = bidDAO.createElement(bid);
		Bid testBid  = bidDAO.getElementById(id);
		assertNotNull(testBid);
	}
	@Test
	public void testUpdate() throws Exception{
		int id = bidDAO.createElement(bid);
		bid.setIdBid(id);
		bidDAO.updateElement(bid);
	}
	@Test
	public void testGetByAuctionId(){
		List<Bid> bidList = bidDAO.getByAuctionId(bid.getAuctionId());
		assertTrue(bidList.size() > 0);
	}
	@Test
	public void testByUserId(){
		List<Bid> bidList = bidDAO.getByAuctionId(bid.getUserId());
		assertTrue(bidList.size() > 0);
	}
	@Test
	public void testGetAllBids(){
		List<Bid> bidList = bidDAO.getAllBids();
		assertTrue(bidList.size() > 0);
	}
	@Test
	public void testGetUserBid(){
		Bid currentBid = bidDAO.getUserBid(bid.getUserId(), bid.getAuctionId());
		assertNotNull(currentBid);
	}
	@Test
	public void testGetWinUserIdByAuctionId(){
		int winUserId = bidDAO.getWinUserIdByAuctionId(bid.getAuctionId());
		assertNotNull(winUserId);
	}
	@Test
	public void testUpdateBidAlotBids(){
		boolean result = bidDAO.updateBid(50.0d, newBid.getUserId(), newBid.getAuctionId());
		assertFalse(result);
	}
}
