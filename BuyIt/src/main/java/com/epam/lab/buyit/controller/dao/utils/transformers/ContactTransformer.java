package com.epam.lab.buyit.controller.dao.utils.transformers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.dao.address.AddressDAO;
import com.epam.lab.buyit.model.Address;
import com.epam.lab.buyit.model.Contact;

public class ContactTransformer implements TransformerInterface<Contact> {
	private static final Logger LOGGER = Logger
			.getLogger(AddressTransformer.class);
	private static final String CREATE_STATEMENT = "INSERT INTO contacts(email, phone, address_id) VALUES(? , ? , ? )";
	private final static String UPDATE_ALL_FIELDS = "UPDATE contacts SET email = ?, phone = ?,address_id = ? WHERE id_contact = ?";
	private AddressDAO addressDAO;
	
	public ContactTransformer() {
		addressDAO = new AddressDAO();
	}

	@Override
	public PreparedStatement fromObjectToCreatePS(Contact elem,
			Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(CREATE_STATEMENT,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, elem.getEmail());
			statement.setString(2, elem.getPhone());
//			statement.setInt(3, elem.getAddressId());

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
//			statement.setInt(3, elem.getAddressId());
			statement.setInt(4, elem.getIdContacts());

		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return statement;
	}

	@Override
	public Contact fromRStoObject(ResultSet resultSet) {
		Contact currentContact = new Contact();
		Address currentAddress = new Address();
		
		try {
			currentContact.setIdContacts(resultSet.getInt("id_contact"));
			currentContact.setEmail(resultSet.getString("email"));
			currentContact.setPhone(resultSet.getString("phone"));
//			currentContact.setAddressId(resultSet.getInt("address_id"));
			
			
			currentAddress = addressDAO.readElementById(resultSet.getInt("address_id"));
			currentContact.setAddress(currentAddress);

		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return currentContact;
	}

}
