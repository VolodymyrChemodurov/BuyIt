package com.epam.lab.buyit.controller.dao.utils.transformers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.model.Description;

public class DescriptionTransformer implements
		TransformerInterface<Description> {

	private static final Logger LOGGER = Logger
			.getLogger(DescriptionTransformer.class);
	private static final String CREATE_STATEMENT = "INSERT INTO descriptions"
			+ "(features, desc_text) VALUES(?, ?)";

	@Override
	public PreparedStatement fromObjectToCreatePS(Description elem,
			Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(CREATE_STATEMENT,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, elem.getFeatures());
			statement.setString(2, elem.getDescText());
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return statement;
	}

	@Override
	public PreparedStatement fromObjectToUpdatePS(Description elem,
			Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Description fromRStoObject(ResultSet resultSet) {
		Description description = new Description();
		try {
			description.setIdDescription(resultSet.getInt("id_description"));
			description.setFeatures(resultSet.getString("features"));
			description.setDescText(resultSet.getString("desc_text"));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return description;
	}

}
