package com.epam.lab.buyit.controller.utils.creator;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import com.epam.lab.buyit.model.Message;

public class MessageCreator {
	private final static Logger LOGGER = Logger.getLogger(MessageCreator.class);

	public Message create(JSONArray json) {
		Message message = new Message();
		try {
			message.setMessage(json.getString(0));
			message.setFromUserId(json.getInt(1));
		} catch (JSONException e) {
			LOGGER.error(e);
		}
		
//		for (MessageSetter currentElement : MessageSetter.values()) {
//			try {
//				String value = json.getString(currentElement.getField());
//				currentElement.setField(message, value);
//			} catch (JSONException e) {
//				LOGGER.error(e);
//			}
//		}
		return message;
	}

}
