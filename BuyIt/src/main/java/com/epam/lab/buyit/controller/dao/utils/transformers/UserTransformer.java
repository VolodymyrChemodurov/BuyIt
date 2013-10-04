package com.epam.lab.buyit.controller.dao.utils.transformers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.dao.contact.ContactDAO;
import com.epam.lab.buyit.model.User;

public class UserTransformer implements TransformerInterface<User> {

	private static final Logger LOGGER = Logger
			.getLogger(UserTransformer.class);
	private static final String CREATE_STATEMENT = "INSERT INTO users"
			+ "(role, first_name, last_name, login, password, contacts_id) VALUES(?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_STATEMENT = "UPDATE users SET "
			+ "role=?, first_name=?, last_name=?, login=?, password=?, contacts_id=? WHERE id_user=?";

	@Override
	public PreparedStatement fromObjectToCreatePS(User elem,
			Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(CREATE_STATEMENT,
					Statement.RETURN_GENERATED_KEYS);
			statement.setBoolean(1, elem.getRole());
			statement.setString(2, elem.getFirstName());
			statement.setString(3, elem.getLastName());
			statement.setString(4, elem.getLogin());
			statement.setString(5, elem.getPassword());
			statement.setInt(6, elem.getContactsId());
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
			statement.setBoolean(1, elem.getRole());
			statement.setString(2, elem.getFirstName());
			statement.setString(3, elem.getLastName());
			statement.setString(4, elem.getLogin());
			statement.setString(5, elem.getPassword());
			statement.setInt(6, elem.getContactsId());
			statement.setInt(7, elem.getIdUser());
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return statement;
	}

	@Override
	public User fromRStoObject(ResultSet resultSet) {
		User user = new User();
		ContactDAO contactDAO = new ContactDAO();
		try {
			user.setIdUser(resultSet.getInt("id_user"));
			user.setRole(resultSet.getBoolean("role"));
			user.setFirstName(resultSet.getString("first_name"));
			user.setLastName(resultSet.getString("last_name"));
			user.setLogin(resultSet.getString("login"));
			user.setPassword(resultSet.getString("password"));
			user.setContactsId(resultSet.getInt("contacts_id"));
			user.setContact(contactDAO.readElementById(user.getContactsId()));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return user;
	}

}
