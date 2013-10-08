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
			+ "(features, desc_text, products_id) VALUES(?, ?, ?)";
	private static final String UPDATE_STATEMENT = "UPDATE descriptions SET "
			+ "features=?, desc_text=?, products_id=? WHERE id_description=?";

	@Override
	public PreparedStatement fromObjectToCreatePS(Description elem,
			Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(CREATE_STATEMENT,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, elem.getFeatures());
			statement.setString(2, elem.getDescText());
			statement.setInt(3, elem.getProductId());
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return statement;
	}

	@Override
	public PreparedStatement fromObjectToUpdatePS(Description elem,
			Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(UPDATE_STATEMENT,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, elem.getFeatures());
			statement.setString(2, elem.getDescText());
			statement.setInt(3, elem.getProductId());
			statement.setInt(4, elem.getIdDescription());
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return statement;
	}

	@Override
	public Description fromRSToObject(ResultSet resultSet) {
		Description description = new Description();
		try {
			description.setIdDescription(resultSet.getInt("id_description"));
			description.setProductId(resultSet.getInt("products_id"));
			description.setFeatures(resultSet.getString("features"));
			description.setDescText(resultSet.getString("desc_text"));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return description;
	}

}
