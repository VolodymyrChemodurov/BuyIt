package com.epam.lab.buyit.controller.creator;

import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.epam.lab.buyit.controller.setters.UserSetter;
import com.epam.lab.buyit.model.User;

public class UserCreator {
	private final static Logger LOGGER = Logger.getLogger(UserCreator.class);

	public User create(Map<String, String[]> inputMap) {
		User createdUser = new User();
		for(UserSetter currentElement: UserSetter.values()){
			String value = inputMap.get(currentElement.getField())[0];
			currentElement.setField(createdUser, value);
		}
		setDefaultValues(createdUser);
		return createdUser;
	}
	
	public User create(JSONObject json) {
		User user = new User();
		for(UserSetter currentElement: UserSetter.values()) {
			try {
				String value = json.getString(currentElement.getField());
				currentElement.setField(user, value);
			} catch (JSONException e) {
				LOGGER.error(e);
			}
		}
		setDefaultValues(user);
		return user;
	}

	private void setDefaultValues(User user) {
		user.setAvatar("bootstrap/img/avatars/user-icon.png");
		user.setBan(false);
	}
}
