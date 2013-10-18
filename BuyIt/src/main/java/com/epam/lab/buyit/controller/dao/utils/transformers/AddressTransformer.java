package com.epam.lab.buyit.controller.dao.utils.transformers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.model.Address;

public class AddressTransformer implements TransformerInterface<Address> {
	private static final Logger LOGGER = Logger.getLogger(AddressTransformer.class);
	private static final String CREATE_STATEMENT = "INSERT INTO address(region, city, street, house, flat, zip_code, contacts_id) VALUES(? , ? , ? , ?, ? , ?, ?)";
	private final static String UPDATE_ALL_FIELDS = "UPDATE address SET  region = ?, city = ?, street =? , house = ? , flat = ?, zip_code = ? WHERE contacts_id = ?";

	private enum Values {
		REGION(1), CITY(2), STREET(3), HOUSE(4), FLAT(5), ZIP_CODE(6), CONTACT_ID(7);
		private int value;

		private Values(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	@Override
	public PreparedStatement fromObjectToCreatePS(Address elem, java.sql.Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(CREATE_STATEMENT, Statement.RETURN_GENERATED_KEYS);
			statement.setString(Values.REGION.getValue(), elem.getRegion());
			statement.setString(Values.CITY.getValue(), elem.getCity());
			statement.setString(Values.STREET.getValue(), elem.getStreet());
			statement.setString(Values.HOUSE.getValue(), elem.getHouse());
			statement.setString(Values.FLAT.getValue(), elem.getFlat());
			statement.setString(Values.ZIP_CODE.getValue(), elem.getZipCode());
			statement.setInt(Values.CONTACT_ID.getValue(), elem.getContactId());
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return statement;
	}

	@Override
	public Address fromRSToObject(ResultSet resultSet) {
		Address currentAddress = new Address();
		try {
			currentAddress.setContactId(resultSet.getInt("contacts_id"));
			currentAddress.setRegion(resultSet.getString("region"));
			currentAddress.setCity(resultSet.getString("city"));
			currentAddress.setStreet(resultSet.getString("street"));
			currentAddress.setHouse(resultSet.getString("house"));
			currentAddress.setFlat(resultSet.getString("flat"));
			currentAddress.setZipCode(resultSet.getString("zip_code"));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return currentAddress;
	}

	@Override
	public PreparedStatement fromObjectToUpdatePS(Address elem, java.sql.Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(UPDATE_ALL_FIELDS);
			statement.setString(Values.REGION.getValue(), elem.getRegion());
			statement.setString(Values.CITY.getValue(), elem.getCity());
			statement.setString(Values.STREET.getValue(), elem.getStreet());
			statement.setString(Values.HOUSE.getValue(), elem.getHouse());
			statement.setString(Values.FLAT.getValue(), elem.getFlat());
			statement.setString(Values.ZIP_CODE.getValue(), elem.getZipCode());
			statement.setInt(Values.CONTACT_ID.getValue(), elem.getContactId());
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return statement;
	}

}
