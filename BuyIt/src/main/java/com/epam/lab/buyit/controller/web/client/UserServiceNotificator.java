package com.epam.lab.buyit.controller.web.client;

import java.net.URI;

import org.codehaus.jettison.json.JSONObject;

import com.epam.lab.buyit.controller.jsonbuilder.JSONBuilder;
import com.epam.lab.buyit.controller.jsonbuilder.adapters.UserSerializationAdapter;
import com.epam.lab.buyit.controller.service.user.UserService;
import com.epam.lab.buyit.controller.service.user.UserServiceImpl;
import com.epam.lab.buyit.controller.utils.WebServicesPropertiesGetter;
import com.epam.lab.buyit.model.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class UserServiceNotificator {
	private static URI baseUri;
	private UserService userService;
	
	static {
		baseUri = WebServicesPropertiesGetter.getForumBaseURI();
	}
	
	public UserServiceNotificator() {
		userService = new UserServiceImpl();
	}
	
	public void inform(int id) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(baseUri);
		
		User user = userService.getItemById(id);
		JSONObject json = JSONBuilder.buildJSONObject(user, new UserSerializationAdapter());
		service.path("/update").queryParam("user", json.toString()).post();
	}
}
