package com.epam.lab.buyit.controller.dao.subcategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.dao.utils.DAOUtils;
import com.epam.lab.buyit.controller.dao.utils.connection.ConnectionManager;
import com.epam.lab.buyit.controller.dao.utils.transformers.SubCategoryTransformer;
import com.epam.lab.buyit.model.SubCategory;

public class SubCategoryDAO implements SubCategoryDAOInterface {

	private final static String GET_BY_ID = "SELECT * FROM sub_categories WHERE id_sub_category = ?";
	private final static String GET_ALL_SUBCATEGORIES_BY_CATEGORY_ID = "SELECT * FROM sub_categories WHERE category_id=?";
	private final static String GET_ALL_SUBCATEGORIES = "SELECT * FROM sub_categories";
	private final static String DELETE = "DELETE FROM sub_categories WHERE id_sub_category = ?";
	private static final Logger LOGGER = Logger.getLogger(SubCategoryDAO.class);
	private SubCategoryTransformer transformer;

	public SubCategoryDAO() {
		transformer = new SubCategoryTransformer();
	}
	
	@Override
	public List<SubCategory> getAllSubCategories() {
		List<SubCategory> subCategories = new ArrayList<SubCategory>();
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection
					.prepareStatement(GET_ALL_SUBCATEGORIES);
			result = statement.executeQuery();
			while (result.next()) {
				SubCategory currentSubCategory = transformer
						.fromRSToObject(result);
				subCategories.add(currentSubCategory);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return subCategories;
	}

	@Override
	public int createElement(SubCategory elem) {
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
	public SubCategory getElementById(int id) {
		SubCategory subCategory = null;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(GET_BY_ID);
			statement.setInt(1, id);
			result = statement.executeQuery();
			if (result.next()) {
				subCategory = transformer.fromRSToObject(result);
				return subCategory;
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return subCategory;
	}

	@Override
	public void updateElement(SubCategory elem) {
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
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection.prepareStatement(DELETE);
			statement.setInt(1, id);
			if (statement != null) {
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		
	}

	@Override
	public List<SubCategory> getAllSubCategoriesByIdCategory(int id_category) {
		List<SubCategory> subCategories = new ArrayList<SubCategory>();
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = connection
					.prepareStatement(GET_ALL_SUBCATEGORIES_BY_CATEGORY_ID);
			statement.setInt(1, id_category);
			result = statement.executeQuery();
			while (result.next()) {
				SubCategory currentSubCategory = transformer
						.fromRSToObject(result);
				subCategories.add(currentSubCategory);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			DAOUtils.close(result, statement, connection);
		}
		return subCategories;
	}

}
