package com.epam.lab.buyit.controller.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.dao.utils.DAOUtils;
import com.epam.lab.buyit.controller.dao.utils.connection.ConnectionManager;
import com.epam.lab.buyit.controller.dao.utils.transformers.UserTransformer;
import com.epam.lab.buyit.model.User;

public class UserDAO implements UserDAOInterface {
	private static final Logger LOGGER = Logger.getLogger(UserDAO.class);
	private final static String GET_BY_ID = "SELECT * FROM users WHERE id_user = ?";
	private final static String GET_ALL_USERS = "SELECT * FROM users";
	private final static String GET_USER_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
	private final static String GET_USER = "SELECT * FROM users WHERE login = ? AND password = ?";
	private final static String CHANGE_PASSWORD = "UPDATE users SET password=? WHERE id_user=?";
	private UserTransformer transformer = new UserTransformer();

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
	public User getElementById(int id) {
		User user = null;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_BY_ID);
			statement.setInt(1, id);
			result = statement.executeQuery();
			if (result.next()) {
				user = transformer.fromRSToObject(result);
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
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_ALL_USERS);
			result = statement.executeQuery();
			while (result.next()) {
				User currentUser = transformer.fromRSToObject(result);
				users.add(currentUser);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return users;
	}

	@Override
	public boolean checkLogin(String login) {
		boolean checkResult = false;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_USER_BY_LOGIN);
			statement.setString(1, login);
			result = statement.executeQuery();
			if (result.next())
				checkResult = true;
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return checkResult;
	}

	@Override
	public User getUser(String login, String password) {
		User user = null;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_USER);
			statement.setString(1, login);
			statement.setString(2, password);
			result = statement.executeQuery();
			if (result.next()) {
				user = transformer.fromRSToObject(result);
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
	public User getUserByLogin(String login) {
		User user = null;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_USER_BY_LOGIN);
			statement.setString(1, login);
			result = statement.executeQuery();
			if (result.next())
				user = transformer.fromRSToObject(result);
			return user;
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return user;
	}

	@Override
	public boolean changePasswordByUserId(int id, String newPassword) {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(CHANGE_PASSWORD);
			statement.setString(1, newPassword);
			statement.setInt(2, id);
			int rows = statement.executeUpdate();
			if (rows == 1) {
				return true;
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(statement, connection);
		}
		return false;
	}

}
