package com.epam.lab.buyit.controller.web.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONObject;

import com.epam.lab.buyit.controller.jsonbuilder.JSONBuilder;
import com.epam.lab.buyit.controller.jsonbuilder.adapters.UserSerializationAdapter;
import com.epam.lab.buyit.controller.service.user.UserServiceImpl;
import com.epam.lab.buyit.model.User;

@Path("/user")
public class UserWebService {
	private UserServiceImpl userService;
	
	public UserWebService() {
		userService = new UserServiceImpl();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getUserById(@PathParam("id") int id) {
		User user = userService.getItemById(id);
		if(user != null) {
			UserSerializationAdapter adapter = new UserSerializationAdapter();
			return JSONBuilder.buildJSONObject(user, adapter);
		}
		else return new JSONObject();
	}

}
