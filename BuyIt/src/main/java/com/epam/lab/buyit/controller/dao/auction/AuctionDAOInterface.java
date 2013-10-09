package com.epam.lab.buyit.controller.dao.auction;

import com.epam.lab.buyit.controller.dao.GenericDAO;
import com.epam.lab.buyit.model.Auction;

public interface AuctionDAOInterface extends GenericDAO<Auction>{

	Auction getByProductId(int productId);
	
}
