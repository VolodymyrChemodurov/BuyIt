package com.epam.lab.buyit.controller.web.client;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.epam.lab.buyit.model.Image;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class ImageClientWebService {

	private static final Logger LOGGER = Logger
			.getLogger(ImageClientWebService.class);

	private static URI baseUri;

	static {		baseUri = UriBuilder.fromUri("http://localhost:8080/").build();
	}

	public String createImage(Image image) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(baseUri);
		JSONObject object = new JSONObject();
		String result = null;
		try {
			object.put("description_id", image.getDescriptionId());
			object.put("path", image.getPath());
			ClientResponse resp = service.accept("application/json")
					.type("application/json")
					.post(ClientResponse.class, object);
			JSONObject jsonObject = resp.getEntity(JSONObject.class);
			result = jsonObject.getString("url");
		} catch (JSONException e) {
			LOGGER.error(e);
		}
		return result;
	}

}
