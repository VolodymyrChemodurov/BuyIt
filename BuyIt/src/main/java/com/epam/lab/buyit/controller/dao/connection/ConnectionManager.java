package com.epam.lab.buyit.controller.dao.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class ConnectionManager {

	private static final Logger LOGGER = Logger.getLogger(ConnectionManager.class);
	private static final String resourcePath = "java:comp/env/jdbc/auction";
	static private DataSource dataSource;

	static {
		try {
			InitialContext initContext = new InitialContext();
			dataSource = (DataSource) initContext.lookup(resourcePath);
		} catch (NamingException e) {
			LOGGER.error(e);
		}

	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return connection;
	}

}