package com.epam.lab.buyit.controller.dao.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DAOUtils {

	private static final Logger LOGGER = Logger.getLogger(DAOUtils.class);

	public static void close(PreparedStatement statement, Connection connection) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				LOGGER.error(e);
			}
		}
	}

	public static void close(ResultSet resultSet, PreparedStatement statement,
			Connection connection) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				LOGGER.error(e);
			} finally {
				try {
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					LOGGER.error(e);
				}
			}
		}
	}

}