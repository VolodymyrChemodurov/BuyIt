package com.epam.lab.buyit.controller.dao.utils.transformers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.dao.description.DescriptionDAO;
import com.epam.lab.buyit.model.Product;

public class ProductTransformer implements TransformerInterface<Product> {

	private static final Logger LOGGER = Logger
			.getLogger(ProductTransformer.class);
	private static final String CREATE_STATEMENT = "INSERT INTO products"
			+ "(name, auction_id, sub_category_id, user_id, description_id) VALUES(?, ?, ?, ?, ?)";

	@Override
	public PreparedStatement fromObjectToCreatePS(Product elem,
			Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(CREATE_STATEMENT,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, elem.getName());
			statement.setInt(2, elem.getAuctionId());
			statement.setInt(3, elem.getSubCategoryId());
			statement.setInt(4, elem.getUserId());
			statement.setInt(5, elem.getDescription().getIdDescription());
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return statement;
	}

	@Override
	public PreparedStatement fromObjectToUpdatePS(Product elem,
			Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product fromRStoObject(ResultSet resultSet) {
		Product product = new Product();
		DescriptionDAO descriptionDAO = new DescriptionDAO();
		try {
			product.setIdProduct(resultSet.getInt("id_product"));
			product.setName(resultSet.getString("name"));
			product.setAuctionId(resultSet.getInt("auction_id"));
			product.setSubCategoryId(resultSet.getInt("sub_category_id"));
			product.setUserId(resultSet.getInt("user_id"));
			product.setDescription(descriptionDAO.readElementById(resultSet
					.getInt("description_id")));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return product;
	}

}
