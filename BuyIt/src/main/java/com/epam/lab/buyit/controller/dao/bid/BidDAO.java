package com.epam.lab.buyit.controller.dao.bid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.dao.address.AddressDAO;
import com.epam.lab.buyit.controller.dao.connection.ConnectionManager;
import com.epam.lab.buyit.controller.dao.utils.DAOUtils;
import com.epam.lab.buyit.controller.dao.utils.transformers.BidTransformer;
import com.epam.lab.buyit.model.Bid;

public class BidDAO implements BidDAOInterface{

	private static final Logger LOGGER = Logger.getLogger(AddressDAO.class);
	private final static String GET_BY_ID = "SELECT * FROM bids WHERE id_bid = ?";
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
	public Bid readElementById(int id) {
		Bid currentBid = null;
		Connection connection = com.epam.lab.buyit.controller.dao.connection.ConnectionManager
				.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_BY_ID);
			statement.setInt(1, id);
			result = statement.executeQuery();
			if (result.next()) {
				currentBid = transformer.fromRStoObject(result);
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
		throw new UnsupportedOperationException();
		
	}

	@Override
	public void deleteElementById(int id) {
		throw new UnsupportedOperationException();
		
	}

}
