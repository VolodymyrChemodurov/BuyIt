package com.epam.lab.buyit.controller.dao.auction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.dao.utils.DAOUtils;
import com.epam.lab.buyit.controller.dao.utils.connection.ConnectionManager;
import com.epam.lab.buyit.controller.dao.utils.transformers.AuctionTransformer;
import com.epam.lab.buyit.model.Auction;

public class AuctionDAO implements AuctionDAOInterface {
	private static final Logger LOGGER = Logger.getLogger(AuctionDAO.class);
	private final static String GET_BY_ID = "SELECT * FROM auctions WHERE id_auction = ?";
	private final static String GET_BY_PRODUCT_ID = "SELECT * FROM auctions WHERE product_id = ?";
	private final static String GET_LATEST = "SELECT * FROM auctions WHERE status='inProgress' AND end_time > ? ORDER BY end_time LIMIT ?";
	private final static String GET_SOON_ENDING = "SELECT * FROM auctions WHERE end_time > ? AND end_time < ? AND  status='inProgress'";
	private final static String CLOSE = "UPDATE auctions SET status='closed' WHERE id_auction = ?";
	private final static String BUY_IT_SERVE = "UPDATE auctions SET count=?, status=? WHERE id_auction=? AND count=? AND status=?";
	private final static String BID_SERVE = "UPDATE auctions SET current_price = ? WHERE id_auction = ? AND status = ? AND current_price = ?";
	private AuctionTransformer transformer;

	public AuctionDAO() {
		transformer = new AuctionTransformer();
	}

	@Override
	public int createElement(Auction elem) {
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
	public Auction getElementById(int id) {
		Auction currentAuctions = null;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_BY_ID);
			statement.setInt(1, id);
			result = statement.executeQuery();
			if (result.next()) {
				currentAuctions = transformer.fromRSToObject(result);
				return currentAuctions;
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return currentAuctions;
	}

	@Override
	public void updateElement(Auction elem) {
		throw new UnsupportedOperationException();

	}

	@Override
	public void deleteElementById(int id) {
		throw new UnsupportedOperationException();

	}

	@Override
	public Auction getByProductId(int productId) {
		Auction currentAuctions = null;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_BY_PRODUCT_ID);
			statement.setInt(1, productId);
			result = statement.executeQuery();
			if (result.next()) {
				currentAuctions = transformer.fromRSToObject(result);
				return currentAuctions;
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return currentAuctions;
	}

	@Override
	public List<Auction> getLatestAuctions(int number, long time) {
		List<Auction> auctions = new ArrayList<Auction>();
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_LATEST);
			statement.setTimestamp(1, new Timestamp(time));
			statement.setInt(2, number);
			result = statement.executeQuery();
			while (result.next()) {
				Auction currentAuction = transformer.fromRSToObject(result);
				auctions.add(currentAuction);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return auctions;
	}

	@Override
	public List<Auction> getSoonEndingAuctions(long currentTime, long endTime) {
		List<Auction> auctions = new ArrayList<Auction>();
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_SOON_ENDING);
			statement.setTimestamp(1, new Timestamp(currentTime));
			statement.setTimestamp(2, new Timestamp(endTime));
			result = statement.executeQuery();
			while (result.next()) {
				Auction currentAuction = transformer.fromRSToObject(result);
				auctions.add(currentAuction);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return auctions;
	}

	@Override
	public void closeAuction(int id) {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(CLOSE);
			statement.setInt(1, id);
			statement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(statement, connection);
		}
	}

	@Override
	public int buyItServe(int id, int count, String status, int oldCount,
			String oldStatus) {
		int affectedRows = 0;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(BUY_IT_SERVE);
			statement.setInt(1, count);
			statement.setString(2, status);
			statement.setInt(3, id);
			statement.setInt(4, oldCount);
			statement.setString(5, oldStatus);
			affectedRows = statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(statement, connection);
		}
		return affectedRows;
	}

	@Override
	public int bidServe(int auctionId, double newCurrentPrice, double oldCurrentPrice, String status) {
		int affectedRows = 0;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(BID_SERVE);
			statement.setDouble(1, newCurrentPrice);
			statement.setInt(2, auctionId);
			statement.setString(3, status);
			statement.setDouble(4, oldCurrentPrice);
			affectedRows = statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(statement, connection);
		}
		return affectedRows;
	}

}
