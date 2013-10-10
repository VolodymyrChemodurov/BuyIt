package com.epam.lab.buyit.controller.dao.utils.transformers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.model.Message;

public class MessageTransformer implements TransformerInterface<Message> {

	private static final Logger LOGGER = Logger
			.getLogger(MessageTransformer.class);
	private static final String CREATE_STATEMENT = "INSERT INTO messages"
			+ "(message, from_user_id, to_user_id) VALUES(?, ?, ?)";
	private static final String UPDATE_STATEMENT = "UPDATE messages SET "
			+ "message=?, from_user_id=?, to_user_id=? WHERE id_message=?";

	@Override
	public PreparedStatement fromObjectToCreatePS(Message elem,
			Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(CREATE_STATEMENT,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, elem.getMessage());
			statement.setInt(2, elem.getFromUserId());
			statement.setInt(3, elem.getToUserId());
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return statement;
	}

	@Override
	public PreparedStatement fromObjectToUpdatePS(Message elem,
			Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(UPDATE_STATEMENT,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, elem.getMessage());
			statement.setInt(2, elem.getFromUserId());
			statement.setInt(3, elem.getToUserId());
			statement.setInt(4, elem.getIdMessage());
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return statement;
	}

	@Override
	public Message fromRSToObject(ResultSet resultSet) {
		Message message = new Message();
		try {
			message.setIdMessage(resultSet.getInt("id_message"));
			message.setMessage(resultSet.getString("message"));
			message.setFromUserId(resultSet.getInt("from_user_id"));
			message.setToUserId(resultSet.getInt("to_user_id"));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return message;
	}

}
