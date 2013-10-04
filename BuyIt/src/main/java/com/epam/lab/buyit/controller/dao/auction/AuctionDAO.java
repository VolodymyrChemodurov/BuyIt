package com.epam.lab.buyit.controller.dao.auction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.dao.address.AddressDAO;
import com.epam.lab.buyit.controller.dao.connection.ConnectionManager;
import com.epam.lab.buyit.controller.dao.utils.transformers.AddressTransformer;
import com.epam.lab.buyit.controller.dao.utils.transformers.AuctionTransformer;
import com.epam.lab.buyit.model.Address;
import com.epam.lab.buyit.model.Auctions;

public class AuctionDAO implements AuctionDAOInterface{
	private static final Logger LOGGER = Logger.getLogger(AuctionDAO.class);
	private final static String GET_BY_ID = "SELECT * FROM auction WHERE id_auction = ?";
	private AuctionTransformer transformer;

	public AuctionDAO() {
		transformer = new AuctionTransformer();
	}
	@Override
	public int createElement(Auctions elem) {
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
			//DAOUtils.close(generatedKeys, statement, connection);
		}
		return 0;
	}

	@Override
	public Auctions readElementById(int id) {
		Auctions currentAuctions = null;
		Connection connection = com.epam.lab.buyit.controller.dao.connection.ConnectionManager
				.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_BY_ID);
			statement.setInt(1, id);
			result = statement.executeQuery();
			if (result.next()) {
				currentAuctions = transformer.fromRStoObject(result);
				return currentAuctions;
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			// DAOUtils.close(result, statement, connection);
		}
		return currentAuctions;
	}

	@Override
	public void updateElement(Auctions elem) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public void deleteElementById(int id) {
		throw new UnsupportedOperationException();
		
	}

}
