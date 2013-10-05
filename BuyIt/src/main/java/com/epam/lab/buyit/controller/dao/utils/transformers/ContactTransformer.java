package com.epam.lab.buyit.controller.dao.utils.transformers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import com.epam.lab.buyit.model.Contact;

public class ContactTransformer implements TransformerInterface<Contact> {
	private static final Logger LOGGER = Logger
			.getLogger(AddressTransformer.class);
	private static final String CREATE_STATEMENT = "INSERT INTO contacts(email, phone, users_id) VALUES(? , ? , ?)";
	private final static String UPDATE_ALL_FIELDS = "UPDATE contacts SET email = ?, phone = ? WHERE users_id = ?";

	@Override
	public PreparedStatement fromObjectToCreatePS(Contact elem,
			Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(CREATE_STATEMENT,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, elem.getEmail());
			statement.setString(2, elem.getPhone());
			statement.setInt(3, elem.getUserId());
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return statement;
	}

	@Override
	public PreparedStatement fromObjectToUpdatePS(Contact elem,
			Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(UPDATE_ALL_FIELDS);
			statement.setString(1, elem.getEmail());
			statement.setString(2, elem.getPhone());
			statement.setInt(3, elem.getUserId());
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return statement;
	}

	@Override
	public Contact fromRSToObject(ResultSet resultSet) {
		Contact currentContact = new Contact();
		try {
			currentContact.setIdContact(resultSet.getInt("id_contact"));
			currentContact.setUserId(resultSet.getInt("users_id"));
			currentContact.setEmail(resultSet.getString("email"));
			currentContact.setPhone(resultSet.getString("phone"));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return currentContact;
	}

}
