package com.epam.lab.buyit.controller.web.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.UriBuilder;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.epam.lab.buyit.model.Message;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class MessageClientWebService {

	private static final Logger LOGGER = Logger.getLogger(MessageClientWebService.class);
	private static URI baseUri;

	static {
		baseUri = UriBuilder.fromUri("http://localhost:8080/").build();
	}

	public List<Message> getMessagesByUserId(int id) {

//		ClientConfig config = new DefaultClientConfig();
//		Client client = Client.create(config);
//		WebResource service = client.resource(baseUri);
		List<Message> messagesList = new ArrayList<Message>();
//		MessageCreator creator = new MessageCreator();
//		JSONObject object = new JSONObject();
//
//		try {
//			object.put("user_id", id);
//			ClientResponse resp = service.accept("application/json").get(ClientResponse.class);
//			JSONObject jsonObject = resp.getEntity(JSONObject.class);
//			JSONArray messages = jsonObject.getJSONArray("messages");
//
//			for (int i = 0; i < messages.length(); i++) {
//				Message currentMessage = creator.create(messages.getJSONObject(i));
//				messagesList.add(currentMessage);
//			}
//
//		} catch (JSONException e) {
//			LOGGER.error(e);
//		}

		//MOCK
		for(int i = 0; i < 20; i++) {
			Message message = new Message();
			message.setToUserId(id);
			message.setFromUserId(i+1).setMessage("Test messsage " + i);
			messagesList.add(message);
		}
		
		return messagesList;
	}

	public boolean createMessage(Message message) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(baseUri);

		JSONObject object = new JSONObject();
		boolean result = false;
		try {
			object.put("message", message.getMessage());
			object.put("from_user_id", message.getFromUserId());
			object.put("to_user_id", message.getToUserId());
			ClientResponse resp = service.accept("application/json")
					.type("application/json")
					.post(ClientResponse.class, object);
			JSONObject jsonObject = resp.getEntity(JSONObject.class);
			result = jsonObject.getBoolean("result");
		} catch (JSONException e) {
			LOGGER.error(e);
		}
		return result;
	}
}
