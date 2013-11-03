package service;

import static org.junit.Assert.*;

import java.sql.Timestamp;

import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.lab.buyit.controller.exception.AuctionAllreadyClosedException;
import com.epam.lab.buyit.controller.exception.BidAmountException;
import com.epam.lab.buyit.controller.service.bid.BidServiceImp;
import com.epam.lab.buyit.model.Bid;

public class TestBidService {
	private static BidServiceImp bidService = null;
	private static Bid bid = null;
	private static Bid newBid = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bidService = new BidServiceImp();

		bid = new Bid();
		bid.setAuctionId(1).setAmount(50.0).setUserId(1)
				.setTime(new Timestamp(System.currentTimeMillis()));

	}

	@Test
	public void testServBid() {
		try {
			boolean result = bidService.serveBid(1, 1, 50.0);
			assertTrue(result);
		} catch (BidAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AuctionAllreadyClosedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = BidAmountException.class)
	public void testServBidAmountExeption() throws BidAmountException, AuctionAllreadyClosedException {
	
			bidService.serveBid(1, 1, 0);
		
	}
	@Test(expected = AuctionAllreadyClosedException.class)
	public void testServBidCloseAuctionExeption() throws BidAmountException, AuctionAllreadyClosedException {
		bidService.serveBid(1, 1, 50.0);
	}
}