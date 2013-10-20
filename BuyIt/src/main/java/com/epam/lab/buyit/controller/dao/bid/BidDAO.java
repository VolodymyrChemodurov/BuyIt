package com.epam.lab.buyit.controller.dao.bid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.dao.utils.DAOUtils;
import com.epam.lab.buyit.controller.dao.utils.connection.ConnectionManager;
import com.epam.lab.buyit.controller.dao.utils.transformers.BidTransformer;
import com.epam.lab.buyit.model.Bid;

public class BidDAO implements BidDAOInterface{

	private static final Logger LOGGER = Logger.getLogger(BidDAO.class);
	private final static String GET_BY_ID = "SELECT * FROM bids WHERE id_bid = ?";
	private final static String GET_BY_AUCTION_ID ="SELECT * FROM bids WHERE auction_id = ?";
	private final static String GET_BY_USER_ID ="SELECT * FROM bids WHERE user_id = ?";
	private final static String GET_ALL_BIDS ="SELECT * FROM bids";
	private final static String GET_USER_BID = "SELECT * FROM bids WHERE auction_id = ? AND user_id = ?";
	private BidTransformer transformer;

	public BidDAO() {
		transformer = new BidTransformer();
	}
	
	@Override
	public int createElement(Bid elem) {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet generatedKeys = null;
		try {	
			statement = transformer.fromObjectToCreatePS(elem, connection);
			if (statement != null) {
				statement.executeUpdate();
				generatedKeys = statement.getGeneratedKeys();
				generatedKeys.next();

				return generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(generatedKeys, statement, connection);
		}
		return 0;
	}

	@Override
	public Bid getElementById(int id) {
		Bid currentBid = null;
		Connection connection = com.epam.lab.buyit.controller.dao.utils.connection.ConnectionManager
				.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_BY_ID);
			statement.setInt(1, id);
			result = statement.executeQuery();
			if (result.next()) {
				currentBid = transformer.fromRSToObject(result);
				return currentBid;
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return currentBid;
	}

	@Override
	public void updateElement(Bid elem) {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		try {
			statement = transformer.fromObjectToUpdatePS(elem, connection);
			if (statement != null) {
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(statement, connection);
		}
		
	}

	@Override
	public void deleteElementById(int id) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public List<Bid> getByAuctionId(int auctionId) {
		Bid currentBid = null;
		List<Bid> bidList = new ArrayList<Bid>();
		Connection connection = com.epam.lab.buyit.controller.dao.utils.connection.ConnectionManager
				.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_BY_AUCTION_ID);
			statement.setInt(1, auctionId);
			result = statement.executeQuery();
			while (result.next()) {
				currentBid = transformer.fromRSToObject(result);
				bidList.add(currentBid);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return bidList;
	}

	@Override
	public List<Bid> getByUserId(int userId) {
		Bid currentBid = null;
		List<Bid> bidList = new ArrayList<Bid>();
		Connection connection = com.epam.lab.buyit.controller.dao.utils.connection.ConnectionManager
				.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_BY_USER_ID);
			statement.setInt(1, userId);
			result = statement.executeQuery();
			while (result.next()) {
				currentBid = transformer.fromRSToObject(result);
				bidList.add(currentBid);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return bidList;
	}

	@Override
	public List<Bid> getAllBids() {
		Bid currentBid = null;
		List<Bid> bidList = new ArrayList<Bid>();
		Connection connection = com.epam.lab.buyit.controller.dao.utils.connection.ConnectionManager
				.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_ALL_BIDS);
			result = statement.executeQuery();
			while (result.next()) {
				currentBid = transformer.fromRSToObject(result);
				bidList.add(currentBid);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return bidList;
	}

	@Override
	public Bid getUserBid(int userId, int auctionId) {
		Bid currentBid = null;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_USER_BID);
			statement.setInt(1, auctionId);
			statement.setInt(2, userId);
			result = statement.executeQuery();
			if (result.next()) {
				currentBid = transformer.fromRSToObject(result);
				return currentBid;
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return currentBid;
	}

}
