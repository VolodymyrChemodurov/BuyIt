package com.epam.lab.buyit.controller.dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.dao.connection.ConnectionManager;
import com.epam.lab.buyit.controller.dao.utils.DAOUtils;
import com.epam.lab.buyit.controller.dao.utils.transformers.ProductTransformer;
import com.epam.lab.buyit.model.Product;

public class ProductDAO implements ProductDAOInterface {

	private final static String GET_BY_ID = "SELECT * FROM products WHERE id_product = ?";
	private static final Logger LOGGER = Logger.getLogger(ProductDAO.class);
	private ProductTransformer transformer;

	@Override
	public int createElement(Product elem) {
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
	public Product readElementById(int id) {
		Product product = null;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_BY_ID);
			statement.setInt(1, id);
			result = statement.executeQuery();
			if (result.next()) {
				product = transformer.fromRStoObject(result);
				return product;
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return product;
	}

	@Override
	public void updateElement(Product elem) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteElementById(int id) {
		throw new UnsupportedOperationException();
	}

}
