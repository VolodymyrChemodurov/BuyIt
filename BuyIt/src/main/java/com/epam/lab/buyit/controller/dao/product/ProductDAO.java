package com.epam.lab.buyit.controller.dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.dao.utils.DAOUtils;
import com.epam.lab.buyit.controller.dao.utils.connection.ConnectionManager;
import com.epam.lab.buyit.controller.dao.utils.transformers.ProductTransformer;
import com.epam.lab.buyit.model.Product;

public class ProductDAO implements ProductDAOInterface {
	private static final Logger LOGGER = Logger.getLogger(ProductDAO.class);
	private final static String GET_BY_ID = "SELECT * FROM products WHERE id_product = ?";
	private final static String GET_ALL_PRODUCTS = "SELECT * FROM products";
	private final static String GET_BY_SUBCATEGORY_ID = "SELECT * FROM products WHERE sub_category_id = ?";
	private final static String GET_SELECTION = "SELECT SQL_CALC_FOUND_ROWS * FROM products WHERE sub_category_id = ? "
			+ "LIMIT ?, ?";
	private final static String GET_ROWS_COUNT_BY_SYBCATEGORY_ID = "SELECT COUNT(id_product) FROM products WHERE sub_category_id = ?";
	private ProductTransformer transformer;

	public ProductDAO() {
		transformer = new ProductTransformer();
	}

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
	public Product getElementById(int id) {
		Product product = null;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_BY_ID);
			statement.setInt(1, id);
			result = statement.executeQuery();
			if (result.next()) {
				product = transformer.fromRSToObject(result);
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
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		try {
			statement = transformer.fromObjectToUpdatePS(elem, connection);
			if (statement != null) {
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(statement, connection);
		}
	}

	@Override
	public void deleteElementById(int id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_ALL_PRODUCTS);
			result = statement.executeQuery();
			while (result.next()) {
				Product currentProduct = transformer.fromRSToObject(result);
				products.add(currentProduct);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return products;
	}

	@Override
	public List<Product> getProductsBySubCategoryId(int subCategoryId) {
		List<Product> products = new ArrayList<Product>();
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_BY_SUBCATEGORY_ID);
			statement.setInt(1, subCategoryId);
			result = statement.executeQuery();
			while (result.next()) {
				Product currentProduct = transformer.fromRSToObject(result);
				products.add(currentProduct);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return products;
	}

	@Override
	public List<Product> getSelectionBySubCategoryId(int id, int offset,
			int numberOfRecords) {

		List<Product> products = new ArrayList<Product>();
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_SELECTION);
			statement.setInt(1, id);
			statement.setInt(2, offset);
			statement.setInt(3, numberOfRecords);
			result = statement.executeQuery();
			while (result.next()) {
				Product currentProduct = transformer.fromRSToObject(result);
				products.add(currentProduct);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return products;
	}

	@Override
	public int getCountBySubCategoryId(int id) {
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_ROWS_COUNT_BY_SYBCATEGORY_ID);
			statement.setInt(1, id);
			result = statement.executeQuery();
			if (result.next())
				return result.getInt(1);
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return 0;
	}

}
