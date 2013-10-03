package com.epam.lab.buyit.controller.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.dao.connection.ConnectionManager;
import com.epam.lab.buyit.controller.dao.utils.DAOUtils;
import com.epam.lab.buyit.controller.dao.utils.transformers.UserTransformer;
import com.epam.lab.buyit.model.User;

public class UserDAO implements UserDAOInterface {

	private final static String GET_BY_ID = "SELECT * FROM users WHERE id_user = ?";
	private static final Logger LOGGER = Logger.getLogger(UserDAO.class);
	private UserTransformer transformer;

	@Override
	public int createElement(User elem) {
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
	public User readElementById(int id) {
		User user = null;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_BY_ID);
			statement.setInt(1, id);
			result = statement.executeQuery();
			if (result.next()) {
				user = transformer.fromRStoObject(result);
				return user;
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return user;
	}

	@Override
	public void updateElement(User elem) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteElementById(int id) {
		throw new UnsupportedOperationException();
	}

}
