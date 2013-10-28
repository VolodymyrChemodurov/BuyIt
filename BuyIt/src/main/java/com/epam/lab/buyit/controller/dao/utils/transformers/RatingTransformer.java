package com.epam.lab.buyit.controller.dao.utils.transformers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;
import com.epam.lab.buyit.model.Rating;

public class RatingTransformer implements TransformerInterface<Rating>{
	private static final Logger LOGGER = Logger.getLogger(RatingTransformer.class);
	private static final String CREATE_STATEMENT = "INSERT INTO ratings"
			+ "(rating, from_id, user_id) VALUES(?, ?, ?)";
	private static final String UPDATE_STATEMENT = "UPDATE ratings SET "
			+ "rating =?, from_id=?, user_id=? WHERE id=?";
	
	@Override
	public PreparedStatement fromObjectToCreatePS(Rating elem, Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(CREATE_STATEMENT, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, elem.getRating());
			statement.setInt(2, elem.getFromId());
			statement.setInt(3, elem.getUserId());
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return statement;
	}

	@Override
	public PreparedStatement fromObjectToUpdatePS(Rating elem, Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(UPDATE_STATEMENT, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, elem.getRating());
			statement.setInt(2, elem.getFromId());
			statement.setInt(3, elem.getUserId());
			statement.setInt(4, elem.getId());
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return statement;
	}

	@Override
	public Rating fromRSToObject(ResultSet resultSet) {
		Rating rating = new Rating();
		try {
			rating.setFromId(resultSet.getInt("from_id"));
			rating.setUserId(resultSet.getInt("user_id"));
			rating.setId(resultSet.getInt("id"));
			rating.setRating(resultSet.getInt("rating"));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return rating;
	}

	
}
