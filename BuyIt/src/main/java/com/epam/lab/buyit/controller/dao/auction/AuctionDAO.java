package com.epam.lab.buyit.controller.dao.auction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.dao.utils.DAOUtils;
import com.epam.lab.buyit.controller.dao.utils.connection.ConnectionManager;
import com.epam.lab.buyit.controller.dao.utils.transformers.AuctionTransformer;
import com.epam.lab.buyit.model.Auction;

public class AuctionDAO implements AuctionDAOInterface{
	private static final Logger LOGGER = Logger.getLogger(AuctionDAO.class);
	private final static String GET_BY_ID = "SELECT * FROM auction WHERE id_auction = ?";
	private final static String GET_BY_PRD_ID = "SELECT * FROM auctions WHERE product_id = ?";
	private AuctionTransformer transformer;

	public AuctionDAO() {
		transformer = new AuctionTransformer();
	}
	
	public Auction getElementByPrdId(int id) {
		Auction currentAuctions = null;
		Connection connection = com.epam.lab.buyit.controller.dao.utils.connection.ConnectionManager
				.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_BY_PRD_ID);
			statement.setInt(1, id);
			result = statement.executeQuery();
			while (result.next()) {
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
		Connection connection = com.epam.lab.buyit.controller.dao.utils.connection.ConnectionManager
				.getConnection();
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

}
