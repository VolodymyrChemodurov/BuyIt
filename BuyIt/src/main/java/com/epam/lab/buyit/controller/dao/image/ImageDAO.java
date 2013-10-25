package com.epam.lab.buyit.controller.dao.image;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.dao.utils.DAOUtils;
import com.epam.lab.buyit.controller.dao.utils.connection.ConnectionManager;
import com.epam.lab.buyit.controller.dao.utils.transformers.ImageTransformer;
import com.epam.lab.buyit.model.Image;

public class ImageDAO implements ImageDAOInterface {

	private final static String GET_BY_ID = "SELECT * FROM images WHERE id_image = ?";
	private final static String GET_BY_DESCRIPTION_ID = "SELECT * FROM images WHERE description_id = ?";
	private static final Logger LOGGER = Logger.getLogger(ImageDAO.class);
	private ImageTransformer transformer;

	public ImageDAO() {
		transformer = new ImageTransformer();
	}

	@Override
	public int createElement(Image elem) {
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
	public Image getElementById(int id) {
		Image image = null;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_BY_ID);
			statement.setInt(1, id);
			result = statement.executeQuery();
			if (result.next()) {
				image = transformer.fromRSToObject(result);
				return image;
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return image;
	}

	@Override
	public void updateElement(Image elem) {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet generatedKeys = null;
		try {
			statement = transformer.fromObjectToUpdatePS(elem, connection);
			if (statement != null) {
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(generatedKeys, statement, connection);
		}
	}

	@Override
	public void deleteElementById(int id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Image> getImagesByDescriptionId(int id) {
		List<Image> images = new ArrayList<Image>();
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_BY_DESCRIPTION_ID);
			statement.setInt(1, id);
			result = statement.executeQuery();
			while(result.next()) {
				images.add(transformer.fromRSToObject(result));
			}
			return images;
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return images;
	}

}
