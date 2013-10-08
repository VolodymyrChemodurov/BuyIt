package com.epam.lab.buyit.controller.dao.category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.dao.utils.DAOUtils;
import com.epam.lab.buyit.controller.dao.utils.connection.ConnectionManager;
import com.epam.lab.buyit.controller.dao.utils.transformers.CategoryTransformer;
import com.epam.lab.buyit.model.Category;

public class CategoryDAO implements CategoryDAOInterface {

	private final static String GET_BY_ID = "SELECT * FROM categories WHERE id_category = ?";
	private final static String GET_ALL_CATEGORIES = "SELECT * FROM categories";
	private static final Logger LOGGER = Logger.getLogger(CategoryDAO.class);
	private CategoryTransformer transformer;

	public CategoryDAO() {
		transformer = new CategoryTransformer();
	}

	@Override
	public int createElement(Category elem) {
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
	public Category getElementById(int id) {
		Category category = null;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_BY_ID);
			statement.setInt(1, id);
			result = statement.executeQuery();
			if (result.next()) {
				category = transformer.fromRSToObject(result);
				return category;
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return category;
	}

	@Override
	public void updateElement(Category elem) {
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
		// TODO Auto-generated method stub

	}

	@Override
	public List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<Category>();
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_ALL_CATEGORIES);
			result = statement.executeQuery();
			while (result.next()) {
				Category currentCategory = transformer.fromRSToObject(result);
				categories.add(currentCategory);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return categories;
	}

}
