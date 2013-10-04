package com.epam.lab.buyit.controller.dao.description;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.dao.connection.ConnectionManager;
import com.epam.lab.buyit.controller.dao.utils.DAOUtils;
import com.epam.lab.buyit.controller.dao.utils.transformers.DescriptionTransformer;
import com.epam.lab.buyit.model.Description;

public class DescriptionDAO implements DescriptionDAOInterface {

	private final static String GET_BY_ID = "SELECT * FROM descriptions WHERE id_description = ?";
	private static final Logger LOGGER = Logger.getLogger(DescriptionDAO.class);
	private DescriptionTransformer transformer = new DescriptionTransformer();

	@Override
	public int createElement(Description elem) {
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
	public Description readElementById(int id) {
		Description description = null;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_BY_ID);
			statement.setInt(1, id);
			result = statement.executeQuery();
			if (result.next()) {
				description = transformer.fromRStoObject(result);
				return description;
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return description;
	}

	@Override
	public void updateElement(Description elem) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteElementById(int id) {
		throw new UnsupportedOperationException();
	}

}
