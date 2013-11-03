package com.epam.lab.buyit.controller.dao.rating;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.dao.utils.DAOUtils;
import com.epam.lab.buyit.controller.dao.utils.connection.ConnectionManager;
import com.epam.lab.buyit.controller.dao.utils.transformers.RatingTransformer;
import com.epam.lab.buyit.model.Rating;

public class RatingDAO implements RatingDAOInterface{
	private static final Logger LOGGER = Logger.getLogger(RatingDAO.class);
	private static final String GET_BY_ID = "SELECT * FROM ratings WHERE id = ?";
	private static final String GET_ALL_BY_USER_ID = "SELECT * FROM ratings WHERE user_id = ?";
	private static final String FIND_MARK = "SELECT * FROM ratings WHERE from_id = ? AND user_id = ?";
	private static final String GET_MARKS_COUNT = "SELECT COUNT(id) FROM ratings WHERE user_id = ?";
	private RatingTransformer transformer;

	public RatingDAO() {
		transformer = new RatingTransformer();
	}
	
	@Override
	public int createElement(Rating elem) {
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
	public Rating getElementById(int id) {
		Rating rating = null;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_BY_ID);
			statement.setInt(1, id);
			result = statement.executeQuery();
			if (result.next()) {
				rating = transformer.fromRSToObject(result);
				return rating;
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return rating;
	}

	@Override
	public void updateElement(Rating elem) {
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
	public List<Rating> getUserRatings(int userId) {
		Rating rating = null;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		List<Rating> list = new ArrayList<Rating>();
		try {
			statement = connection.prepareStatement(GET_ALL_BY_USER_ID);
			statement.setInt(1, userId);
			result = statement.executeQuery();
			while (result.next()) {
				rating = transformer.fromRSToObject(result);
				list.add(rating);
			}
			return list;
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return list;
	}

	@Override
	public Rating findMark(int fromId, int toId) {
		Rating rating = null;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(FIND_MARK);
			statement.setInt(1, fromId);
			statement.setInt(2, toId);
			result = statement.executeQuery();
			if (result.next()) {
				rating = transformer.fromRSToObject(result);
				return rating;
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return rating;
	}

	@Override
	public int getUserMarksCount(int id) {
		int count = 0;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_MARKS_COUNT);
			statement.setInt(1, id);
			result = statement.executeQuery();
			if (result.next()) {
				count = result.getInt(1);
				return count;
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return count;
	}


}
