package com.epam.lab.buyit.controller.dao.utils.transformers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.model.Category;

public class CategoryTransformer implements TransformerInterface<Category> {

	private static final Logger LOGGER = Logger
			.getLogger(CategoryTransformer.class);
	private static final String CREATE_STATEMENT = "INSERT INTO categories"
			+ "(name) VALUES (?) ";
	private static final String UPDATE_STATEMENT = "UPDATE categories SET "
			+ "name=? WHERE id_category=?";

	@Override
	public PreparedStatement fromObjectToCreatePS(Category elem,
			Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(CREATE_STATEMENT,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, elem.getName());
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return statement;
	}

	@Override
	public PreparedStatement fromObjectToUpdatePS(Category elem,
			Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(UPDATE_STATEMENT,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, elem.getName());
			statement.setInt(2, elem.getIdCategory());
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return statement;
	}

	@Override
	public Category fromRSToObject(ResultSet resultSet) {
		Category category = new Category();
		try {
			category.setIdCategory(resultSet.getInt("id_category"));
			category.setName(resultSet.getString("name"));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return category;
	}

}
