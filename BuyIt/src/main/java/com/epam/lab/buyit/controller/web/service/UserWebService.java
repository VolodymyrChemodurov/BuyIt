package com.epam.lab.buyit.controller.web.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONObject;

import com.epam.lab.buyit.controller.jsonbuilder.JSONBuilder;
import com.epam.lab.buyit.model.User;

@Path("/user")
public class UserWebService {

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getUserById(@PathParam("id") int id) {
		User user = createUserMock(id);
		return JSONBuilder.buildJSONOblect(user);
	}

	private User createUserMock(int id) {
		User user = new User();
		user.setFirstName("Mike").setLastName("Snow").setLogin("Admin")
				.setPassword("root").setIdUser(id).setStatus(true);
		return user;
	}
}
