package com.epam.lab.buyit.controller.service.bid;

import java.util.List;

import com.epam.lab.buyit.controller.service.GenericService;
import com.epam.lab.buyit.model.Bid;

public interface BidService extends GenericService<Bid> {
	List<Bid> getByAuctionId(int auctionid);
}
