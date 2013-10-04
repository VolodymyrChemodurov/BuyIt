package com.epam.lab.buyit.controller.dao.utils.transformers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import com.epam.lab.buyit.model.Bid;

public class BidTransformer implements TransformerInterface<Bid>{
	private static final Logger LOGGER = Logger
			.getLogger(AddressTransformer.class);
	private static final String CREATE_STATEMENT = "INSERT INTO bids(time, auction_id, user_id) VALUES(? , ? , ?)";

	@Override
	public PreparedStatement fromObjectToCreatePS(Bid elem,
			Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(CREATE_STATEMENT,
					Statement.RETURN_GENERATED_KEYS);
			statement.setTime(1, elem.getTime());
			statement.setInt(2, elem.getAuctionId());
			statement.setInt(3, elem.getUserId());

		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return statement;
	}

	@Override
	public PreparedStatement fromObjectToUpdatePS(Bid elem,
			Connection connection) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Bid fromRStoObject(ResultSet resultSet) {
		Bid currentBid = new Bid();
		try {
			currentBid.setIdBid(resultSet.getInt("id_bid"));
			currentBid.setTime(resultSet.getTime("time"));
			currentBid.setAuctionId(resultSet.getInt("auction_id"));
			currentBid.setUserId(resultSet.getInt("user_id"));

		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return currentBid;
	}

}
