package com.epam.lab.buyit.controller.web.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import com.epam.lab.buyit.controller.jsonbuilder.JSONBuilder;
import com.epam.lab.buyit.controller.jsonbuilder.adapters.UserListSerializationAdapter;
import com.epam.lab.buyit.controller.jsonbuilder.adapters.UserSerializationAdapter;
import com.epam.lab.buyit.controller.service.user.UserServiceImpl;
import com.epam.lab.buyit.model.User;

@Path("/user")
public class UserWebService {
	private static final Logger LOGGER = Logger.getLogger(UserWebService.class);
	private static String LOGIN, PASSWORD;
	private static final String propFilePath = "D:\\Repsitory\\BuyIt\\BuyIt\\src\\main\\java\\web-services.properties";
	private UserServiceImpl userService;

	static {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(propFilePath));
			LOGIN = prop.getProperty("user.login");
			PASSWORD = prop.getProperty("user.password");
		} catch (IOException e) {
			LOGGER.error(e);
			LOGIN = PASSWORD = "";
		} 
	}
	
	public UserWebService() {
		userService = new UserServiceImpl();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getUserById(@PathParam("id") int id,
			@QueryParam("login") String login,
			@QueryParam("password") String password) {

		if (authentication(login, password)) {
			User user = userService.getItemById(id);
			if (user != null) {
				UserSerializationAdapter adapter = new UserSerializationAdapter();
				return JSONBuilder.buildJSONObject(user, adapter);
			}
		}
		return new JSONObject();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getUsers(@QueryParam("login") String login,
			@QueryParam("password") String password) {
		
		if (authentication(login, password)) {
			List<User> users = userService.getAllItems();
			UserListSerializationAdapter adapter = new UserListSerializationAdapter();
			return JSONBuilder.buildbuildJSONObject(users, adapter);
		}
		return new JSONObject();
	}

	private boolean authentication(String login, String password) {
		boolean authenticationResult = false;
		if (login != null && password != null) {
			if (login.equals(LOGIN) && password.equals(PASSWORD))
				authenticationResult = true;
		}
		return authenticationResult;
	}
}
