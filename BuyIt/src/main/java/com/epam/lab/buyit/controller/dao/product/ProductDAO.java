package com.epam.lab.buyit.controller.dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.dao.connection.ConnectionManager;
import com.epam.lab.buyit.controller.dao.utils.DAOUtils;
import com.epam.lab.buyit.controller.dao.utils.transformers.ProductTransformer;
import com.epam.lab.buyit.model.Product;

public class ProductDAO implements ProductDAOInterface {

	private final static String GET_BY_ID = "SELECT * FROM products WHERE id_product = ?";
	
	private final static String GET_PRD_BY_NAME = "SELECT * FROM products WHERE name LIKE ? ORDER BY name";
	private final static String GET_PRD_BY_CATEGORY = "SELECT * FROM categories WHERE name LIKE ? ORDER BY name";
	private final static String GET_PRD_BY_NAME_CATEGORY = "SELECT * FROM categories t1 INNER JOIN sub_categories t2 ON cayegories.id_category=sub_categories.category_id WHERE name LIKE ? ORDER BY t1.id_category DESC LIMIT 0,10";
	/*поправити сам запит*/
	
	private static final Logger LOGGER = Logger.getLogger(ProductDAO.class);
	private ProductTransformer transformer = new ProductTransformer();
	
	public List<Product> findElementByNameCategory(String prdName, String category) {
		Product product = null;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		List<Product> list = new ArrayList<Product>();
		try {
			statement = connection.prepareStatement(GET_PRD_BY_NAME_CATEGORY);
			statement.setString(1, category);
			statement.setString(2, "%" + category + "%");
			statement.setString(3, "%" + prdName + "%");
			result = statement.executeQuery();
			while (result.next()) {
				product = transformer.fromRStoObject(result);
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
			statement.setString(1, "%" + name + "%");
			result = statement.executeQuery();
			while (result.next()) {
				product = transformer.fromRStoObject(result);
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
				product = transformer.fromRStoObject(result);
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
