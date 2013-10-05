package com.epam.lab.buyit.controller.dao.subcategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.dao.utils.DAOUtils;
import com.epam.lab.buyit.controller.dao.utils.connection.ConnectionManager;
import com.epam.lab.buyit.controller.dao.utils.transformers.SubCategoryTransformer;
import com.epam.lab.buyit.model.SubCategory;

public class SubCategoryDAO implements SubCategoryDAOInterface {

	private final static String GET_BY_ID = "SELECT * FROM sub_categories WHERE id_sub_category = ?";
	private static final Logger LOGGER = Logger.getLogger(SubCategoryDAO.class);
	private SubCategoryTransformer transformer;

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
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteElementById(int id) {
		throw new UnsupportedOperationException();
	}

}
