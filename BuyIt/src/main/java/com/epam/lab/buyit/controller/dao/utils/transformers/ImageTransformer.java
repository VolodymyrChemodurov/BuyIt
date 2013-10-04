package com.epam.lab.buyit.controller.dao.utils.transformers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.model.Image;

public class ImageTransformer implements TransformerInterface<Image> {

	private static final Logger LOGGER = Logger
			.getLogger(ImageTransformer.class);
	private static final String CREATE_STATEMENT = "INSERT INTO images"
			+ "(description_id, path) VALUES(?, ?)";

	@Override
	public PreparedStatement fromObjectToCreatePS(Image elem,
			Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(CREATE_STATEMENT,
					Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, elem.getDescriptionId());
			statement.setString(2, elem.getPath());
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return statement;
	}

	@Override
	public PreparedStatement fromObjectToUpdatePS(Image elem,
			Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image fromRStoObject(ResultSet resultSet) {
		Image image = new Image();
		try {
			image.setIdImage(resultSet.getInt("id_image"));
			image.setDescriptionId(resultSet.getInt("description_id"));
			image.setPath(resultSet.getString("path"));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return image;
	}

}
