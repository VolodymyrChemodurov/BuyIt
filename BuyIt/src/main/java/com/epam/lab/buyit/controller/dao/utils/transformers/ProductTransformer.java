package com.epam.lab.buyit.controller.dao.utils.transformers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import com.epam.lab.buyit.model.Product;

public class ProductTransformer implements TransformerInterface<Product> {

	private static final Logger LOGGER = Logger
			.getLogger(ProductTransformer.class);
	private static final String CREATE_STATEMENT = "INSERT INTO products"
			+ "(name, sub_category_id, user_id, delivery, deleted) VALUES(?, ?, ?, ?, ?)";
	private static final String UPDATE_STATEMENT = "UPDATE products SET "
			+ "name=?, sub_category_id=?, user_id=?, delivery=?, deleted=? WHERE id_product=?";

	@Override
	public PreparedStatement fromObjectToCreatePS(Product elem,
			Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(CREATE_STATEMENT,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, elem.getName());
			statement.setInt(2, elem.getSubCategoryId());
			statement.setInt(3, elem.getUserId());
			statement.setString(4, elem.getDelivery());
			statement.setBoolean(5, elem.getDeleted());
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return statement;
	}

	@Override
	public PreparedStatement fromObjectToUpdatePS(Product elem,
			Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(UPDATE_STATEMENT,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, elem.getName());
			statement.setInt(2, elem.getSubCategoryId());
			statement.setInt(3, elem.getUserId());
			statement.setString(4, elem.getDelivery());
			statement.setBoolean(5, elem.getDeleted());
			statement.setInt(6, elem.getIdProduct());
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return statement;
	}

	@Override
	public Product fromRSToObject(ResultSet resultSet) {
		Product product = new Product();
		try {
			product.setIdProduct(resultSet.getInt("id_product"));
			product.setName(resultSet.getString("name"));
			product.setSubCategoryId(resultSet.getInt("sub_category_id"));
			product.setUserId(resultSet.getInt("user_id"));
			product.setDelivery(resultSet.getString("delivery"));
			product.setDeleted(resultSet.getBoolean("deleted"));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return product;
	}

}
