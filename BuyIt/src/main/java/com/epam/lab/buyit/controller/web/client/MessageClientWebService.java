package com.epam.lab.buyit.controller.web.client;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.UriBuilder;

import com.epam.lab.buyit.model.Message;

public class MessageClientWebService {

	private static URI baseUri;

	static {
		baseUri = UriBuilder.fromUri("http://localhost:8080/").build();
	}

	public List<Message> getMessagesByUserId(int id) {

		return null;
	}

	public void createMessage(Message message) {

	}

}
