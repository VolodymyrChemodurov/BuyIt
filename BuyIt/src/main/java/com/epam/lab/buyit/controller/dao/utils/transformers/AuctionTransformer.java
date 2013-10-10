package com.epam.lab.buyit.controller.dao.utils.transformers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.model.Auction;

public class AuctionTransformer implements TransformerInterface<Auction> {
	private static final Logger LOGGER = Logger
			.getLogger(AddressTransformer.class);
	private static final String CREATE_STATEMENT = "INSERT INTO auctions(start_price, start_time, end_time, status, buy_it_now, count, current_price, product_id) VALUES(? , ? , ? , ? , ? , ?, ?, ?)";

	// private final static String UPDATE_ALL_FIELDS =
	// "UPDATE auctions SET start_price = ?, start_time = ?, end_time= ?, status= ?, buy_it_now= ?, count= ?, current_price= ?, product_id= ? WHERE id_auction = ?";

	@Override
	public PreparedStatement fromObjectToCreatePS(Auction elem,
			Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(CREATE_STATEMENT,
					Statement.RETURN_GENERATED_KEYS);
			statement.setDouble(1, elem.getStartPrice());
			statement.setTimestamp(2, elem.getStartTime());
			statement.setTimestamp(3, elem.getEndTime());
			statement.setString(4, elem.getStatus());
			statement.setDouble(5, elem.getBuyItNow());
			statement.setInt(6, elem.getCount());
			statement.setDouble(7, elem.getCurrentPrice());
			statement.setInt(8, elem.getProductId());
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return statement;
	}

	@Override
	public PreparedStatement fromObjectToUpdatePS(Auction elem,
			Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Auction fromRSToObject(ResultSet resultSet) {
		Auction currentAuctions = new Auction();
		try {
			currentAuctions.setIdAuction(resultSet.getInt("id_auction"));
			currentAuctions.setStartPrice(resultSet.getDouble("start_price"));
			currentAuctions.setStartTime(resultSet.getTimestamp("start_time"));
			currentAuctions.setEndTime(resultSet.getTimestamp("end_time"));
			currentAuctions.setStatus(resultSet.getString("status"));
			currentAuctions.setBuyItNow(resultSet.getDouble("buy_it_now"));
			currentAuctions.setCount(resultSet.getInt("count"));
			currentAuctions.setProductId(resultSet.getInt("product_id"));
			currentAuctions.setCurrentPrice(resultSet
					.getDouble("current_price"));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return currentAuctions;
	}

}
