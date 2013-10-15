package com.epam.lab.buyit.controller.dao.utils.transformers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.model.Bid;

public class BidTransformer implements TransformerInterface<Bid> {
	private static final Logger LOGGER = Logger
			.getLogger(AddressTransformer.class);
	private static final String CREATE_STATEMENT = "INSERT INTO bids(time, amount, auction_id, user_id) VALUES(? , ? , ? , ?)";
	private final static String UPDATE_ALL_FIELDS = "UPDATE bids SET  time = ?, amount = ?, auction_id =? , user_id = ? WHERE id_bid = ?";
	
	private enum Values {
		TIME(1), AMOUNT(2), AUCTION_ID(3), USER_ID(4), BID_ID(5);
		private int value;

		private Values(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}
	
	@Override
	public PreparedStatement fromObjectToCreatePS(Bid elem,
			Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(CREATE_STATEMENT,
					Statement.RETURN_GENERATED_KEYS);
			statement.setTimestamp(Values.TIME.getValue(), elem.getTime());
			statement.setDouble(Values.AMOUNT.getValue(), elem.getAmount());
			statement.setInt(Values.AUCTION_ID.getValue(), elem.getAuctionId());
			statement.setInt(Values.USER_ID.getValue(), elem.getUserId());

		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return statement;
	}

	@Override
	public PreparedStatement fromObjectToUpdatePS(Bid elem,
			Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(UPDATE_ALL_FIELDS);
			statement.setTimestamp(Values.TIME.getValue(), elem.getTime());
			statement.setDouble(Values.AMOUNT.getValue(), elem.getAmount());
			statement.setInt(Values.AUCTION_ID.getValue(),elem.getAuctionId());
			statement.setInt(Values.USER_ID.getValue(), elem.getUserId());
			statement.setInt(Values.BID_ID.getValue(), elem.getIdBid());
			
			
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return statement;
	}

	@Override
	public Bid fromRSToObject(ResultSet resultSet) {
		Bid currentBid = new Bid();
		try {
			currentBid.setIdBid(resultSet.getInt("id_bid"));
			currentBid.setTime(resultSet.getTimestamp("time"));
			currentBid.setAmount(resultSet.getDouble("amount"));
			currentBid.setAuctionId(resultSet.getInt("auction_id"));
			currentBid.setUserId(resultSet.getInt("user_id"));

		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return currentBid;
	}

}
