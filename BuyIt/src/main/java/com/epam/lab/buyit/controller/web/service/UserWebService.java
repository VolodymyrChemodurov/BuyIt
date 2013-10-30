package com.epam.lab.buyit.controller.web.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.epam.lab.buyit.controller.creator.UserCreator;
import com.epam.lab.buyit.controller.jsonbuilder.JSONBuilder;
import com.epam.lab.buyit.controller.jsonbuilder.adapters.UserListSerializationAdapter;
import com.epam.lab.buyit.controller.jsonbuilder.adapters.UserSerializationAdapter;
import com.epam.lab.buyit.controller.service.user.UserServiceImpl;
import com.epam.lab.buyit.controller.validator.UserValidation;
import com.epam.lab.buyit.model.User;

@Path("/user")
public class UserWebService {
	private static final Logger LOGGER = Logger.getLogger(UserWebService.class);
	private static String LOGIN, PASSWORD;
	private static final String propFilePath = "web-services.properties";
	private UserServiceImpl userService;

	static {
		Properties prop = new Properties();
		LOGGER.info("Loading web-services properties...");
		try {
			prop.load(UserWebService.class.getClassLoader()
					.getResourceAsStream(propFilePath));
			LOGIN = prop.getProperty("user.login");
			PASSWORD = prop.getProperty("user.password");
			LOGGER.info("Web-services properties loading complete.");
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

		LOGGER.info("getting user by id " + id);
		if (authentication(login, password)) {
			User user = userService.getItemById(id);
			if (user != null) {
				UserSerializationAdapter adapter = new UserSerializationAdapter();
				LOGGER.info("sending user data");
				return JSONBuilder.buildJSONObject(user, adapter);
			}
		}
		return new JSONObject();
	}

	@GET
	@Path("/bandle")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getUsersBundle(
			@QueryParam("usersArray") String usersArray,
			@QueryParam("login") String login,
			@QueryParam("password") String password) throws JSONException {

		LOGGER.info("getting users bundle");

		List<User> usersBundle = new ArrayList<User>();
		JSONObject jsonObject = new JSONObject(usersArray);
		JSONArray jsonArray = jsonObject.getJSONArray("usersArray");
		if (authentication(login, password)) {
			for (int i = 0; i < jsonArray.length(); i++) {
				int id = jsonArray.getInt(i);
				User user = userService.getItemById(id);
				usersBundle.add(user);
			}
			UserListSerializationAdapter adapter = new UserListSerializationAdapter();
			return JSONBuilder.buildbuildJSONObject(usersBundle, adapter);
		}
		return new JSONObject();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getUsers(@QueryParam("login") String login,
			@QueryParam("password") String password) {

		LOGGER.info("getting users");
		if (authentication(login, password)) {
			List<User> users = userService.getAllItems();
			UserListSerializationAdapter adapter = new UserListSerializationAdapter();
			return JSONBuilder.buildbuildJSONObject(users, adapter);
		}
		return new JSONObject();
	}

	@GET
	@Path("/sign_in/{login}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject loginUser(@PathParam("login") String userLogin,
			@PathParam("password") String userPassword,
			@QueryParam("login") String login,
			@QueryParam("password") String password) {

		StringBuilder infoString = new StringBuilder(
				"try to login user with login = ").append(userLogin)
				.append(" password = ").append(userPassword);
		LOGGER.info(infoString);

		if (authentication(login, password)) {
			User user = userService.getUser(userLogin, userPassword);
			if (user != null) {
				LOGGER.info("Success login");
				UserSerializationAdapter adapter = new UserSerializationAdapter();
				return JSONBuilder.buildJSONObject(user, adapter);
			} else {
				LOGGER.info("Fail to login");
			}
		}
		return new JSONObject();
	}

	@POST
	@Path("/registration")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject registerUser(String parameters) {

		LOGGER.info("Trying to register user");
		LOGGER.info(parameters);
		
		try {
			JSONObject json = new JSONObject(parameters);
			if (UserValidation.checkingInput(json)) {
				User user = new UserCreator().create(json);
				if (!userService.checkLogin(user.getLogin())) {
					user = userService.createItem(user);
					UserSerializationAdapter adapter = new UserSerializationAdapter();
					return JSONBuilder.buildJSONObject(user, adapter);
				}
			}
		} catch (JSONException e) {
			LOGGER.error(e);
		}
		
		return new JSONObject();
	}

	@GET
	@Path("/check")
	@Produces(MediaType.APPLICATION_JSON)
	public String checkLogin(@QueryParam("userLogin") String userLogin,
			@QueryParam("login") String login,
			@QueryParam("password") String password) {
		
		String result = "true";
		if (authentication(login, password)) {
			boolean checkResult = userService.checkLogin(userLogin);
			result = checkResult ? "false" : "true";
		}
		return result;
	}

	private boolean authentication(String login, String password) {
		LOGGER.info("starting authentication...");
		boolean authenticationResult = false;
		if (login != null && password != null) {
			if (login.equals(LOGIN) && password.equals(PASSWORD))
				authenticationResult = true;
		}

		if (authenticationResult) {
			LOGGER.info("successful authentication");
		} else
			LOGGER.info("authentication fails");

		return authenticationResult;
	}

}
