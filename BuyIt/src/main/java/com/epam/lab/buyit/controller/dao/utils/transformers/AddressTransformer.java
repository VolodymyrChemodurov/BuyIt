package com.epam.lab.buyit.controller.dao.utils.transformers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.model.Address;

public class AddressTransformer implements TransformerInterface<Address> {
	private static final Logger LOGGER = Logger
			.getLogger(AddressTransformer.class);
	private static final String CREATE_STATEMENT = "INSERT INTO address(region, city, street, house, zip_code) VALUES(? , ? , ? , ? , ? )";
	private final static String UPDATE_ALL_FIELDS = "UPDATE address SET  region = ?, city = ?, street =? , house = ? , zip_code = ? WHERE id_address = ?";
	
	private enum Values{
		REGION(1), CITY(2), STREET(3), HOUSE(4),ZIP_CODE(5), ID_ADDRESS(6);
		private int value;
		
		private Values(int value){
			this.value = value;
		}
		public int getValue(){
			return value;
		}
		
	}
	@Override
	public PreparedStatement fromObjectToCreatePS(Address elem,
			java.sql.Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(CREATE_STATEMENT,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(Values.REGION.getValue(), elem.getRegion());
			statement.setString(Values.CITY.getValue(), elem.getCity());
			statement.setString(Values.STREET.getValue(), elem.getStreet());
			statement.setString(Values.HOUSE.getValue(), elem.getHouse());
			statement.setString(Values.ZIP_CODE.getValue(), elem.getZipCode());

		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return statement;
	}

	@Override
	public Address fromRStoObject(ResultSet resultSet) {
		Address currentAddress = new Address();
		try {
			currentAddress.setIdAddress(resultSet.getInt("id_address"));
			currentAddress.setRegion(resultSet.getString("region"));
			currentAddress.setCity(resultSet.getString("city"));
			currentAddress.setStreet(resultSet.getString("street"));
			currentAddress.setHouse(resultSet.getString("house"));
			currentAddress.setZipCode(resultSet.getString("zip_code"));

		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return currentAddress;
	}

	@Override
	public PreparedStatement fromObjectToUpdatePS(Address elem,
			java.sql.Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(UPDATE_ALL_FIELDS);
			statement.setString(Values.REGION.getValue(), elem.getRegion());
			statement.setString(Values.CITY.getValue(), elem.getCity());
			statement.setString(Values.STREET.getValue(), elem.getStreet());
			statement.setString(Values.HOUSE.getValue(), elem.getHouse());
			statement.setString(Values.ZIP_CODE.getValue(), elem.getZipCode());

			statement.setInt(Values.ID_ADDRESS.getValue(), elem.getIdAddress());

		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return statement;
	}

}
