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
	private final static String GET_PRD_BY_NAME = "SELECT * FROM products WHERE name LIKE ? ORDER BY name";
	private final static String GET_PRD_BY_CATEGORY = "SELECT * FROM products WHERE sub_category_id IN (SELECT id_sub_category FROM sub_categories WHERE category_id = (SELECT id_category FROM categories WHERE categories.name = ?)) ORDER BY products.name";
	private final static String GET_PRD_BY_NAME_CATEGORY = "SELECT * FROM products WHERE sub_category_id IN (SELECT id_sub_category FROM sub_categories WHERE category_id = (SELECT id_category FROM categories WHERE categories.name = ?)) AND products.name LIKE ? ORDER BY products.name";
	private final static String GET_BY_USER_ID = "SELECT * FROM products WHERE user_id = ?";
	private final static String GET_WON_BY_USER_ID = "SELECT * FROM products WHERE id_product IN (SELECT product_id	FROM (auctions A JOIN (SELECT * FROM bids WHERE user_id = ?) B  ON B.auction_id=A.id_auction) WHERE (amount = current_price)AND(status='closed'))";
	private final static String GET_ACTIVE_BY_USER_ID = "SELECT * FROM products WHERE id_product IN (SELECT product_id	FROM (auctions A JOIN (SELECT * FROM bids WHERE user_id = ?) B  ON B.auction_id=A.id_auction) WHERE status='inProgress')";
	private final static String GET_LOST_BY_USER_ID = "SELECT * FROM products WHERE id_product IN (SELECT product_id FROM (auctions A JOIN (SELECT * FROM bids WHERE user_id = ?) B  ON B.auction_id=A.id_auction) WHERE (amount < current_price)AND(status='closed'))";
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
	
	public List<Product> findElementByNameCategory(String prdName, String category) {
		Product product = null;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		List<Product> list = new ArrayList<Product>();
		try {
			statement = connection.prepareStatement(GET_PRD_BY_NAME_CATEGORY);
			statement.setString(1, category);
			statement.setString(2, "%" + prdName + "%");
			result = statement.executeQuery();
			while (result.next()) {
				product = transformer.fromRSToObject(result);
				list.add(product);
			}
			return list;
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return list;
	}
	
	public List<Product> findElementByCategory(String name) {
		Product product = null;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		List<Product> list = new ArrayList<Product>();
		try {
			statement = connection.prepareStatement(GET_PRD_BY_CATEGORY);
			statement.setString(1, name);
			result = statement.executeQuery();
			while (result.next()) {
				product = transformer.fromRSToObject(result);
				list.add(product);
			}
			return list;
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return list;
	}

	
	public List<Product> findElementByName(String name) {
		Product product = null;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		List<Product> list = new ArrayList<Product>();
		try {
			statement = connection.prepareStatement(GET_PRD_BY_NAME);
			statement.setString(1, "%" + name + "%");
			result = statement.executeQuery();
			while (result.next()) {
				product = transformer.fromRSToObject(result);
				list.add(product);
			}
			return list;
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return list;
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

	public List<Product> getElementsByUserId(int id) {
		List<Product> products = new ArrayList<Product>();
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_BY_USER_ID);
			statement.setInt(1, id);
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
	
	public List<Product> getWonElementsByUserId(int id) {
		List<Product> products = new ArrayList<Product>();
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_WON_BY_USER_ID);
			statement.setInt(1, id);
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

	public List<Product> getLostElementsByUserId(int id) {
		List<Product> products = new ArrayList<Product>();
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_LOST_BY_USER_ID);
			statement.setInt(1, id);
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

	public List<Product> getActiveElementsByUserId(int id) {
		List<Product> products = new ArrayList<Product>();
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_ACTIVE_BY_USER_ID);
			statement.setInt(1, id);
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

}
