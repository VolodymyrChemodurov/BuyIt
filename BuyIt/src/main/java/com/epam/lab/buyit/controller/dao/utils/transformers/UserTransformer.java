package com.epam.lab.buyit.controller.dao.utils.transformers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.model.User;

public class UserTransformer implements TransformerInterface<User> {

	private static final Logger LOGGER = Logger
			.getLogger(UserTransformer.class);
	private static final String CREATE_STATEMENT = "INSERT INTO users"
			+ "(status, first_name, last_name, login, password) VALUES(?, ?, ?, ?, ?)";
	private static final String UPDATE_STATEMENT = "UPDATE users SET "
			+ "status=?, first_name=?, last_name=?, login=?, password=? WHERE id_user=?";

	@Override
	public PreparedStatement fromObjectToCreatePS(User elem,
			Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(CREATE_STATEMENT,
					Statement.RETURN_GENERATED_KEYS);
			statement.setBoolean(1, elem.getStatus());
			statement.setString(2, elem.getFirstName());
			statement.setString(3, elem.getLastName());
			statement.setString(4, elem.getLogin());
			statement.setString(5, elem.getPassword());
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return statement;
	}

	@Override
	public PreparedStatement fromObjectToUpdatePS(User elem,
			Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(UPDATE_STATEMENT,
					Statement.RETURN_GENERATED_KEYS);
			statement.setBoolean(1, elem.getStatus());
			statement.setString(2, elem.getFirstName());
			statement.setString(3, elem.getLastName());
			statement.setString(4, elem.getLogin());
			statement.setString(5, elem.getPassword());
			statement.setInt(6, elem.getIdUser());
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return statement;
	}

	@Override
	public User fromRStoObject(ResultSet resultSet) {
		User user = new User();
		try {
			user.setIdUser(resultSet.getInt("id_user"));
			user.setStatus(resultSet.getBoolean("status"));
			user.setFirstName(resultSet.getString("first_name"));
			user.setLastName(resultSet.getString("last_name"));
			user.setLogin(resultSet.getString("login"));
			user.setPassword(resultSet.getString("password"));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return user;
	}

}
