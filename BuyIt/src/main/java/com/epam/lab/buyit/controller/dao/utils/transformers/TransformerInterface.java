package com.epam.lab.buyit.controller.dao.utils.transformers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface TransformerInterface<T> {

	PreparedStatement fromObjectToCreatePS(T elem, Connection connection);

	PreparedStatement fromObjectToUpdatePS(T elem, Connection connection);

	T fromRStoObject(ResultSet resultSet);

}
