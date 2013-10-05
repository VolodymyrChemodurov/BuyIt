package com.epam.lab.buyit.controller.dao.contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.dao.utils.DAOUtils;
import com.epam.lab.buyit.controller.dao.utils.connection.ConnectionManager;
import com.epam.lab.buyit.controller.dao.utils.transformers.ContactTransformer;
import com.epam.lab.buyit.model.Contact;

public class ContactDAO implements ContactDAOInterface {
	private static final Logger LOGGER = Logger.getLogger(ContactDAO.class);
	private final static String GET_BY_ID = "SELECT * FROM contacts WHERE users_id = ?";
	private ContactTransformer transformer;

	public ContactDAO() {
		transformer = new ContactTransformer();
	}

	@Override
	public int createElement(Contact elem) {
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
	public Contact getElementById(int id) {
		Contact currentContact = null;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_BY_ID);
			statement.setInt(1, id);
			result = statement.executeQuery();
			if (result.next()) {
				currentContact = transformer.fromRSToObject(result);
				return currentContact;
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			 DAOUtils.close(result, statement, connection);
		}
		return currentContact;
	}

	@Override
	public void updateElement(Contact elem) {
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

}
