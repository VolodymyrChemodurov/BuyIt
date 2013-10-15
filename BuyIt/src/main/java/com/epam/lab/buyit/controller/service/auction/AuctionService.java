package com.epam.lab.buyit.controller.service.auction;

import java.util.List;

import com.epam.lab.buyit.controller.service.GenericService;
import com.epam.lab.buyit.model.Auction;

public interface AuctionService extends GenericService<Auction> {

	Auction getByProductId(int id);
	
	List<Auction> getLatestAuctions(int number);
}
