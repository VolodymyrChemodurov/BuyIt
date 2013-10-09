package com.epam.lab.buyit.controller.dao.utils.transformers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.model.SubCategory;

public class SubCategoryTransformer implements
		TransformerInterface<SubCategory> {

	private static final Logger LOGGER = Logger
			.getLogger(SubCategoryTransformer.class);
	private static final String CREATE_STATEMENT = "INSERT INTO sub_categories"
			+ "(name, category_id) VALUES(?, ?)";
	private static final String UPDATE_STATEMENT = "UPDATE sub_categories SET "
			+ "name=?, category_id=? WHERE id_sub_category=?";

	@Override
	public PreparedStatement fromObjectToCreatePS(SubCategory elem,
			Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(CREATE_STATEMENT,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, elem.getName());
			statement.setInt(2, elem.getCategoryId());
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return statement;
	}

	@Override
	public PreparedStatement fromObjectToUpdatePS(SubCategory elem,
			Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(UPDATE_STATEMENT,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, elem.getName());
			statement.setInt(2, elem.getCategoryId());
			statement.setInt(3, elem.getIdSubCategory());
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return statement;
	}

	@Override
	public SubCategory fromRSToObject(ResultSet resultSet) {
		SubCategory subCategory = new SubCategory();
		try {
			subCategory.setIdSubCategory(resultSet.getInt("id_sub_category"));
			subCategory.setName(resultSet.getString("name"));
			subCategory.setCategoryId(resultSet.getInt("category_id"));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return subCategory;
	}

}
