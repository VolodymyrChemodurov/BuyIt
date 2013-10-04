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

	private enum Values {
		ROLE(1), FIRST_NAME(2), LAST_NAME(3), LOGIN(4), PASSWORD(5), CONTACTS_ID(
				6), ID_USER(7);
		private int value;

		private Values(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

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
			statement.setBoolean(Values.ROLE.getValue(), elem.getRole());
			statement.setString(Values.FIRST_NAME.getValue(),
					elem.getFirstName());
			statement
					.setString(Values.LAST_NAME.getValue(), elem.getLastName());
			statement.setString(Values.LOGIN.getValue(), elem.getLogin());
			statement.setString(Values.PASSWORD.getValue(), elem.getPassword());
			statement.setInt(Values.CONTACTS_ID.getValue(),
					elem.getContactsId());
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
			statement.setBoolean(Values.ROLE.getValue(), elem.getRole());
			statement.setString(Values.FIRST_NAME.getValue(),
					elem.getFirstName());
			statement
					.setString(Values.LAST_NAME.getValue(), elem.getLastName());
			statement.setString(Values.LOGIN.getValue(), elem.getLogin());
			statement.setString(Values.PASSWORD.getValue(), elem.getPassword());
			statement.setInt(Values.CONTACTS_ID.getValue(),
					elem.getContactsId());
			statement.setInt(Values.ID_USER.getValue(), elem.getIdUser());
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
